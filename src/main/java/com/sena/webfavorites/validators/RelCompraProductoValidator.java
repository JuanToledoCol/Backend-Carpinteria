package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.RelComprasProductos;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class RelCompraProductoValidator {

	public static void save(RelComprasProductos relProducto) {
		if (relProducto.getIdCompra() == null) {
			throw new ValidateServiceException("Debes estar en una compra.");
		}
		if (relProducto.getIdProducto() == null) {
			throw new ValidateServiceException("Debes tener un producto.");
		}
	}
}
