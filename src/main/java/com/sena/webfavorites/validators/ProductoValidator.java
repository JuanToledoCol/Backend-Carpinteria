package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Producto;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class ProductoValidator {
	public static void save(Producto producto) {
		if (producto.getNombre().trim().isEmpty() || producto.getNombre() == null) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		if (producto.getDescripcion().trim().isEmpty() || producto.getDescripcion() == null) {
			throw new ValidateServiceException("La descripcion es obligatorio.");
		}
		if (producto.getImagen().trim().isEmpty() || producto.getImagen() == null) {
			throw new ValidateServiceException("La imagen es obligatorio.");
		}
		if (producto.getCantidad() <= 0) {
			throw new ValidateServiceException("La cantidad esobligatorio.");
		}
	}
}
