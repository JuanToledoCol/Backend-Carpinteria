package com.sena.webfavorites.dtos;

import com.sena.webfavorites.entity.Compra;
import com.sena.webfavorites.entity.Producto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RelCompraProductoDTO {

	private Long idRelCompraProducto;
	private Compra idCompra;
	private Producto idProducto;
}
