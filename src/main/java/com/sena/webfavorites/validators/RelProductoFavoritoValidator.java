package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.RelProductoFavorito;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class RelProductoFavoritoValidator {

	public static void save(RelProductoFavorito relProducto) {
		if (relProducto.getIdFavorito() == null) {
			throw new ValidateServiceException("Debes tener un favorito.");
		}
		if (relProducto.getIdProducto() == null) {
			throw new ValidateServiceException("Debes tener un producto.");
		}
	}
}
