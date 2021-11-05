package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Categoria;

public class CategoriaValidator {

	public static void save(Categoria categoria) {
		if(categoria.getNombre().trim().isEmpty() || categoria.getNombre() == null) {
			throw new RuntimeException("El nombre no puede estar vacio");
		}
	}
}
