package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.RelProductoFavorito;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.RelProductoFavoritoRepository;
import com.sena.webfavorites.validators.RelProductoFavoritoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelProductoFavoritoService {

	@Autowired
	private RelProductoFavoritoRepository relRepo;

	public List<RelProductoFavorito> findAll() {
		try {
			List<RelProductoFavorito> rel = relRepo.findAll();
			return rel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public RelProductoFavorito findById(Long idRel) {
		try {
			RelProductoFavorito rel = relRepo.findById(idRel)
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
			RelProductoFavorito rel = relRepo.findById(idRel)
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
	public RelProductoFavorito save(RelProductoFavorito rel) {
		try {
			RelProductoFavoritoValidator.save(rel);

			if (rel.getIdRelProducto() == null) {
				RelProductoFavorito relN = relRepo.save(rel);
				return relN;
			}

			RelProductoFavorito relUp = relRepo.findById(rel.getIdRelProducto())
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));

			relUp.setIdFavorito(rel.getIdFavorito());
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
