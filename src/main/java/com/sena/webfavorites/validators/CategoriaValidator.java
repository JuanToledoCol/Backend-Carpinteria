package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Categoria;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class CategoriaValidator {

	public static void save(Categoria categoria) {
		if(categoria.getNombreCategoria().trim().isEmpty() || categoria.getNombreCategoria() == null) {
			throw new ValidateServiceException("El nombre no puede estar vacio");
		}
	}
}
