package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.RelUsuarioPermiso;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class RelUsuarioPermisoValidator {

	public static void save(RelUsuarioPermiso relUsuario) {
		if (relUsuario.getIdPermiso() == null) {
			throw new ValidateServiceException("Debes tener un permiso.");
		}
		if (relUsuario.getIdUsuario() == null) {
			throw new ValidateServiceException("Debes tener un usuario.");
		}
	}
}
