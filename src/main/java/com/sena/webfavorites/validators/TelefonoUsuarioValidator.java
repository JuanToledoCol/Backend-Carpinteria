package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.TelefonoUsuario;
import com.sena.webfavorites.exceptions.ValidateServiceException;
public class TelefonoUsuarioValidator {

	public static void save(TelefonoUsuario telefono) {
		if (telefono.getTelefono().trim().isEmpty()) {
			throw new ValidateServiceException("El Numero de telefono es obligatorio.");
		}
	}
}
