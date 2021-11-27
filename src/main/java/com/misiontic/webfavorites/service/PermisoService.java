package com.misiontic.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Permiso;
import com.misiontic.webfavorites.exceptions.GeneralServiceException;
import com.misiontic.webfavorites.exceptions.NoDataFoundException;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;
import com.misiontic.webfavorites.repository.PermisoRepository;
import com.misiontic.webfavorites.validators.PermisoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PermisoService {

	@Autowired
	private PermisoRepository permisoRepo;

	public List<Permiso> findAll() {
		try {
			List<Permiso> permisos = permisoRepo.findAll();
			return permisos;

		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Permiso findById(Long idPermiso) {
		try {
			Permiso permiso = permisoRepo.findById(idPermiso)
					.orElseThrow(() -> new NoDataFoundException("El Permiso no existe"));
			return permiso;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idPermiso) {
		try {
			Permiso permiso = permisoRepo.findById(idPermiso)
					.orElseThrow(() -> new NoDataFoundException("El Permiso no existe"));
			permisoRepo.delete(permiso);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Permiso save(Permiso permiso) {
		try {
			PermisoValidator.save(permiso);

			if (permiso.getIdPermiso() == null) {
				Permiso permisoN = permisoRepo.save(permiso);
				return permisoN;
			}

			Permiso permisoUp = permisoRepo.findById(permiso.getIdPermiso())
					.orElseThrow(() -> new NoDataFoundException("El Permiso no existe"));

			permisoUp.setNombre(permiso.getNombre());
			permisoUp.setRuta(permiso.getRuta());
			permisoUp.setIconos(permiso.getIconos());

			permisoRepo.save(permisoUp);
			return permisoUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
