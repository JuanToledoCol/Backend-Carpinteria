package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.CompraDTO;
import com.sena.webfavorites.entity.Compra;

public class CompraConv extends AbstracConverter<Compra, CompraDTO>{

	@Override
	public Compra toEntity(CompraDTO dto) {
		return Compra.builder()
				.idCompra(dto.getIdCompra())
				.idUsuario(dto.getIdUsuario())
				.fechaCompra(dto.getFechaCompra())
				.build();
	}

	@Override
	public CompraDTO toDTO(Compra entity) {
		return CompraDTO.builder()
		.idCompra(entity.getIdCompra())
		.idUsuario(entity.getIdUsuario())
		.fechaCompra(entity.getFechaCompra())
		.build();
	}

}
