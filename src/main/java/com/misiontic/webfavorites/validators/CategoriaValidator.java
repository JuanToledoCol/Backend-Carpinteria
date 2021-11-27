package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Categoria;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;

public class CategoriaValidator {

	public static void save(Categoria categoria) {
		if(categoria.getNombre().trim().isEmpty() || categoria.getNombre() == null) {
			throw new ValidateServiceException("El nombre no puede estar vacio");
		}
	}
}
