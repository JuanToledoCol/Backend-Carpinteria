package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.TiposDocumentos;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class TiposDocumentosValidator {

	public static void save(TiposDocumentos tiposDocumentos) {
		if(tiposDocumentos.getNombreTD().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
	}
}
