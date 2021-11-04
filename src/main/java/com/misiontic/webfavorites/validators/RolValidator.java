package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Rol;

public class RolValidator {
	public static void save(Rol rol) {
		if(rol.getNombre().trim().isEmpty() || rol.getNombre() == null){
			throw new RuntimeException("El nombre esobligatorio.");
		}
	}
}
