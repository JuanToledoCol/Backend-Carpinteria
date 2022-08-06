package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Rol;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class RolValidator {
	public static void save(Rol rol) {
		if(rol.getNombreRol().trim().isEmpty() || rol.getNombreRol() == null){
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
	}
}
