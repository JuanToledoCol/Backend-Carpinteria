package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Permiso;
public class PermisoValidator {

	public static void save(Permiso permiso) {
		if (permiso.getNombre().trim().isEmpty() || permiso.getNombre() == null) {
			throw new RuntimeException("El nombre esobligatorio.");
		}
		if (permiso.getRuta().trim().isEmpty() || permiso.getRuta() == null) {
			throw new RuntimeException("La descripcion esobligatorio.");
		}
	}
}
