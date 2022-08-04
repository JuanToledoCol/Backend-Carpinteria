package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.RelUsuarioPermiso;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.RelUsuarioPermisoRepository;
import com.sena.webfavorites.validators.RelUsuarioPermisoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelUsuarioPermisoService {

	@Autowired
	private RelUsuarioPermisoRepository relRepo;

	public List<RelUsuarioPermiso> findAll() {
		try {
			List<RelUsuarioPermiso> rel = relRepo.findAll();
			return rel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public RelUsuarioPermiso findById(Long idRel) {
		try {
			RelUsuarioPermiso rel = relRepo.findById(idRel)
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
			RelUsuarioPermiso rel = relRepo.findById(idRel)
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
	public RelUsuarioPermiso save(RelUsuarioPermiso rel) {
		try {
			RelUsuarioPermisoValidator.save(rel);

			if (rel.getIdRelUsuarioPermiso() == null) {
				RelUsuarioPermiso relN = relRepo.save(rel);
				return relN;
			}

			RelUsuarioPermiso relUp = relRepo.findById(rel.getIdRelUsuarioPermiso())
					.orElseThrow(() -> new NoDataFoundException("El producto no existe."));

			relUp.setIdPermiso(rel.getIdPermiso());
			relUp.setIdUsuario(rel.getIdUsuario());
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
