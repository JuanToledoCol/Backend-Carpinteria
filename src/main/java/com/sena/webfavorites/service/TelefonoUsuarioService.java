package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.TelefonoUsuario;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.TelefonoUsuarioRepository;
import com.sena.webfavorites.validators.TelefonoUsuarioValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TelefonoUsuarioService {

	@Autowired
	private TelefonoUsuarioRepository telRepo;

	public List<TelefonoUsuario> findAll() {
		try {
			List<TelefonoUsuario> tel = telRepo.findAll();
			return tel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public TelefonoUsuario findById(Long idTelefono) {
		try {
			TelefonoUsuario tel = telRepo.findById(idTelefono)
					.orElseThrow(() -> new NoDataFoundException("El telefono no existe."));
			return tel;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idTelefono) {
		try {
			TelefonoUsuario tel = telRepo.findById(idTelefono)
					.orElseThrow(() -> new NoDataFoundException("El Telefono no existe."));
			telRepo.delete(tel);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public TelefonoUsuario save(TelefonoUsuario tel) {
		try {
			TelefonoUsuarioValidator.save(tel);

			if (tel.getIdTelUsuario() == null) {
				TelefonoUsuario relN = telRepo.save(tel);
				return relN;
			}

			TelefonoUsuario telUp = telRepo.findById(tel.getIdTelUsuario())
					.orElseThrow(() -> new NoDataFoundException("El telefono no existe."));

			telUp.setTelefono(tel.getTelefono());
			telRepo.save(telUp);

			return telUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}
