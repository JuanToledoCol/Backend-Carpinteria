package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Favorito;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;


public class FavoritoValidator {

	public static void save(Favorito favorito) {
		if (favorito.getIdCliente() == null) {
			throw new ValidateServiceException("El cliente no puede estar vacio");
		}
		if (favorito.getIdUsuario() == null) {
			throw new ValidateServiceException("El Usuario no puede estar vacio");
		}
		if (favorito.getFecha() == null) {
			throw new ValidateServiceException("La fecha no puede estar vacio");
		}
	}
}
