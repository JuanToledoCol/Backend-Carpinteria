package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Direccion;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class DireccionValidator {

	public static void save(Direccion direccion) {
		if (direccion.getDireccion().trim().isEmpty()) {
			throw new ValidateServiceException("La direccion es obligatorio.");
		}
	}
}
