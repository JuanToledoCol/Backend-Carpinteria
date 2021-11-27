package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Rol;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;

public class RolValidator {
	public static void save(Rol rol) {
		if(rol.getNombre().trim().isEmpty() || rol.getNombre() == null){
			throw new ValidateServiceException("El nombre esobligatorio.");
		}
	}
}
