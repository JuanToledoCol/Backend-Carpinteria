package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.RelCompraProductoDTO;
import com.sena.webfavorites.entity.RelComprasProductos;

public class RelCompraProductoConv  extends AbstracConverter<RelComprasProductos, RelCompraProductoDTO>{

	@Override
	public RelComprasProductos toEntity(RelCompraProductoDTO dto) {
		return RelComprasProductos.builder()
				.idRelCompraProducto(dto.getIdRelCompraProducto())
				.idCompra(dto.getIdCompra())
				.idProducto(dto.getIdProducto())
				.build();
	}

	@Override
	public RelCompraProductoDTO toDTO(RelComprasProductos entity) {
		return RelCompraProductoDTO.builder()
				.idRelCompraProducto(entity.getIdRelCompraProducto())
				.idCompra(entity.getIdCompra())
				.idProducto(entity.getIdProducto())
				.build();
	}

}
