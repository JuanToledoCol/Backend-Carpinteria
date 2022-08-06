package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.TiposDocumentos;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.TiposDocumentosRepository;
import com.sena.webfavorites.validators.TiposDocumentosValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TiposDocumentosService {

	@Autowired
	private TiposDocumentosRepository tdRepo;

	public List<TiposDocumentos> findAll(){
		try {
			List<TiposDocumentos> td = tdRepo.findAll();
			return td;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public TiposDocumentos findById(Long idTipoDocumento) {
		try {
			TiposDocumentos td = tdRepo.findById(idTipoDocumento).orElseThrow(() -> new NoDataFoundException("El usuario no existe"));
			return td;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idTipoDocumento) {
		try {
			TiposDocumentos td = tdRepo.findById(idTipoDocumento).orElseThrow(() -> new NoDataFoundException("El usuario no existe"));
			tdRepo.delete(td);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public TiposDocumentos save(TiposDocumentos tipoDocumento) {
		try {
			TiposDocumentosValidator.save(tipoDocumento);

			if(tipoDocumento.getIdTipoDocumento() == null) {
				TiposDocumentos tdN = tdRepo.save(tipoDocumento);
				return tdN;
			}

			TiposDocumentos tdUp = tdRepo.findById(tipoDocumento.getIdTipoDocumento()).orElseThrow(() -> new NoDataFoundException("El usuario no existe"));

			tdUp.setNombreTD(tipoDocumento.getNombreTD());


			tdRepo.save(tdUp);

			return tdUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
