package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.RelUsuarioPermiso;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;

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
