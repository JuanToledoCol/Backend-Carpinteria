package com.misiontic.webfavorites.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Producto;
import com.misiontic.webfavorites.repository.ProductoRepository;
import com.misiontic.webfavorites.validators.ProductoValidator;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository produRepo;

	public List<Producto> findAll() {
		List<Producto> productos = produRepo.findAll();
		return productos;
	}

	public Producto findById(Long idProducto) {
		Producto producto = produRepo.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("El producto no existe."));
		return producto;
	}

	@Transactional
	public void delete(Long idProducto) {
		Producto producto = produRepo.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("El producto no existe."));
		produRepo.delete(producto);
	}

	@Transactional
	public Producto save(Producto producto) {
		ProductoValidator.save(producto);

		if (producto.getIdProducto() == null) {
			Producto productoN = produRepo.save(producto);
			return productoN;
		}
		
		Producto productoUp = produRepo.findById(producto.getIdProducto())
				.orElseThrow(() -> new RuntimeException("El producto no existe."));
		
		productoUp.setIdUsuario(producto.getIdUsuario());
		productoUp.setIdCategoria(producto.getIdCategoria());
		productoUp.setNombre(producto.getNombre());
		productoUp.setCantidad(producto.getCantidad());
		productoUp.setDescripcion(producto.getDescripcion());
		productoUp.setImagen(producto.getImagen());
		productoUp.setFechaCreacion(producto.getFechaCreacion());
		
		produRepo.save(productoUp);
		
		return productoUp;
	}
}
