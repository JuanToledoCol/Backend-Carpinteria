package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Producto;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.ProductoRepository;
import com.sena.webfavorites.validators.ProductoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoService {

	@Autowired
	private ProductoRepository produRepo;

	public List<Producto> findAll() {
		try {
			List<Producto> productos = produRepo.findAll();
			return productos;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public List<Producto> findByCategoria(String nombreCategoria) {
		try {
			List<Producto> productoPorCategoria = produRepo.findByIdCategoriaNombreCategoria(nombreCategoria);
			return productoPorCategoria;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Producto findById(Long idProducto) {
		try {
			Producto producto = produRepo.findById(idProducto)
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));
			return producto;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idProducto) {
		try {
			Producto producto = produRepo.findById(idProducto)
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));
			produRepo.delete(producto);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Producto save(Producto producto) {
		try {
			ProductoValidator.save(producto);

			if (producto.getIdProducto() == null) {
				Producto productoN = produRepo.save(producto);
				return productoN;
			}

			Producto productoUp = produRepo.findById(producto.getIdProducto())
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));

			productoUp.setIdCategoria(producto.getIdCategoria());
			productoUp.setNombreProducto(producto.getNombreProducto());
			productoUp.setStock(producto.getStock());
			productoUp.setDescripcion(producto.getDescripcion());
			productoUp.setPrecio(producto.getPrecio());
			productoUp.setFechaCreacionProducto(producto.getFechaCreacionProducto());

			produRepo.save(productoUp);

			return productoUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}


}
