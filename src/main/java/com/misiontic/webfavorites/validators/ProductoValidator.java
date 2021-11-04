package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Producto;

public class ProductoValidator {
	public static void save(Producto producto) {
		if (producto.getNombre().trim().isEmpty() || producto.getNombre() == null) {
			throw new RuntimeException("El nombre esobligatorio.");
		}
		if (producto.getDescripcion().trim().isEmpty() || producto.getDescripcion() == null) {
			throw new RuntimeException("La descripcion esobligatorio.");
		}
		if (producto.getImagen().trim().isEmpty() || producto.getImagen() == null) {
			throw new RuntimeException("La imagen esobligatorio.");
		}
		if (producto.getCantidad() <= 0 || producto.getCantidad() == null) {
			throw new RuntimeException("La cantidad esobligatorio.");
		}
	}
}
