package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.RelComprasProductos;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.RelCompraProductoRepository;
import com.sena.webfavorites.validators.RelCompraProductoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelCompraProductoService {

	@Autowired
	private RelCompraProductoRepository relRepo;

	public List<RelComprasProductos> findAll() {
		try {
			List<RelComprasProductos> rel = relRepo.findAll();
			return rel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public RelComprasProductos findById(Long idRel) {
		try {
			RelComprasProductos rel = relRepo.findById(idRel)
					.orElseThrow(() -> new NoDataFoundException("La relacion no existe."));
			return rel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idRel) {
		try {
			RelComprasProductos rel = relRepo.findById(idRel)
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));
			relRepo.delete(rel);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public RelComprasProductos save(RelComprasProductos rel) {
		try {
			RelCompraProductoValidator.save(rel);

			if (rel.getIdRelCompraProducto() == null) {
				RelComprasProductos relN = relRepo.save(rel);
				return relN;
			}

			RelComprasProductos relUp = relRepo.findById(rel.getIdRelCompraProducto())
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));

			relUp.setIdCompra(rel.getIdCompra());
			relUp.setIdProducto(rel.getIdProducto());
			relRepo.save(relUp);

			return relUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
