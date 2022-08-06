package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Compra;
import com.sena.webfavorites.exceptions.ValidateServiceException;


public class CompraValidator {

	public static void save(Compra compra) {
		if (compra.getIdUsuario() == null) {
			throw new ValidateServiceException("El Usuario no puede estar vacio");
		}
		if (compra.getFechaCompra() == null) {
			throw new ValidateServiceException("La fecha no puede estar vacio");
		}
	}
}
