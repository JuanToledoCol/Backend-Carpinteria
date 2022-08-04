package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Permiso;
import com.sena.webfavorites.exceptions.ValidateServiceException;
public class PermisoValidator {

	public static void save(Permiso permiso) {
		if (permiso.getNombre().trim().isEmpty() || permiso.getNombre() == null) {
			throw new ValidateServiceException("El nombre esobligatorio.");
		}
		if (permiso.getRuta().trim().isEmpty() || permiso.getRuta() == null) {
			throw new ValidateServiceException("La descripcion es obligatorio.");
		}
		if (permiso.getIconos().trim().isEmpty() || permiso.getIconos() == null) {
			throw new ValidateServiceException("El icono es obligatorio.");
		}
	}
}
