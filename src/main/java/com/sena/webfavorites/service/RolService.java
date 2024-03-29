package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Rol;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.RolRepository;
import com.sena.webfavorites.validators.RolValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RolService {

	@Autowired
	private RolRepository rolRepo;

	public List<Rol> findAll() {
		try {
			List<Rol> roles = rolRepo.findAll();
			return roles;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Rol findById(Long idRol) {
		try {
			Rol rol = rolRepo.findById(idRol).orElseThrow(() -> new NoDataFoundException("No existe ese Rol"));
			return rol;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idRol) {
		try {
			Rol rol = rolRepo.findById(idRol).orElseThrow(() -> new NoDataFoundException("No existe ese Rol"));
			rolRepo.delete(rol);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Rol save(Rol rol) {
		try {
			RolValidator.save(rol);

			if (rol.getIdRol() == null) {
				Rol rolN = rolRepo.save(rol);
				return rolN;
			}

			Rol rolUp = rolRepo.findById(rol.getIdRol())
					.orElseThrow(() -> new NoDataFoundException("No existe ese Rol"));

			rolUp.setNombreRol(rol.getNombreRol());

			rolRepo.save(rolUp);

			return rolUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
