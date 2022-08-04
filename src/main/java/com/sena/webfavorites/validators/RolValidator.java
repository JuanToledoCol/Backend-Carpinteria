package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Rol;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class RolValidator {
	public static void save(Rol rol) {
		if(rol.getNombre().trim().isEmpty() || rol.getNombre() == null){
			throw new ValidateServiceException("El nombre esobligatorio.");
		}
	}
}
