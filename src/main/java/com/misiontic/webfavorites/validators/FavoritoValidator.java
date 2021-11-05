package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Favorito;


public class FavoritoValidator {

	public static void save(Favorito favorito) {
		if (favorito.getIdCliente() == null) {
			throw new RuntimeException("El cliente no puede estar vacio");
		}
		if (favorito.getIdUsuario() == null) {
			throw new RuntimeException("El Usuario no puede estar vacio");
		}
		if (favorito.getFechaAgregado() == null) {
			throw new RuntimeException("La fecha no puede estar vacio");
		}
	}
}
