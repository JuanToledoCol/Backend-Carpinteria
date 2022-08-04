package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Categoria;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class CategoriaValidator {

	public static void save(Categoria categoria) {
		if(categoria.getNombre().trim().isEmpty() || categoria.getNombre() == null) {
			throw new ValidateServiceException("El nombre no puede estar vacio");
		}
	}
}
