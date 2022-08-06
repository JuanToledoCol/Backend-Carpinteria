package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Producto;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class ProductoValidator {
	public static void save(Producto producto) {
		if (producto.getNombreProducto().trim().isEmpty() || producto.getNombreProducto() == null) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		if (producto.getDescripcion().trim().isEmpty() || producto.getDescripcion() == null) {
			throw new ValidateServiceException("La descripcion es obligatorio.");
		}
		if (producto.getPrecio().isNaN() || producto.getPrecio() == null) {
			throw new ValidateServiceException("La imagen es obligatorio.");
		}
		if (producto.getStock() <= 0) {
			throw new ValidateServiceException("La cantidad es obligatorio.");
		}
	}
}
