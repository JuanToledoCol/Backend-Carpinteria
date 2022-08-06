package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Direccion;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.DireccionRepository;
import com.sena.webfavorites.validators.DireccionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DireccionService {

	@Autowired
	private DireccionRepository dirRepo;

	public List<Direccion> findAll() {
		try {
			List<Direccion> dir = dirRepo.findAll();
			return dir;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Direccion findById(Long direccion) {
		try {
			Direccion dir = dirRepo.findById(direccion)
					.orElseThrow(() -> new NoDataFoundException("La Direccion no existe."));
			return dir;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long direccion) {
		try {
			Direccion dir = dirRepo.findById(direccion)
					.orElseThrow(() -> new NoDataFoundException("La Direccion no existe."));
			dirRepo.delete(dir);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Direccion save(Direccion dir) {
		try {
			DireccionValidator.save(dir);

			if (dir.getIdDireccion() == null) {
				Direccion dirN = dirRepo.save(dir);
				return dirN;
			}

			Direccion dirUp = dirRepo.findById(dir.getIdDireccion())
					.orElseThrow(() -> new NoDataFoundException("La Direccion no existe."));

			dirUp.setDireccion(dir.getDireccion());
			dirRepo.save(dirUp);

			return dirUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}

