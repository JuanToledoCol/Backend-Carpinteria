package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.RelProductoFavorito;
import com.misiontic.webfavorites.exceptions.ValidateServiceException;

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
