package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.DireccionDTO;
import com.sena.webfavorites.entity.Direccion;

public class DireccionConv extends AbstracConverter<Direccion, DireccionDTO>{

	@Override
	public Direccion toEntity(DireccionDTO dto) {
		return Direccion.builder()
				.idDireccion(dto.getIdDireccion())
				.direccion(dto.getDireccion())
				.idUsuario(dto.getIdUsuario())
				.build();
	}

	@Override
	public DireccionDTO toDTO(Direccion entity) {
		return DireccionDTO.builder()
			.idDireccion(entity.getIdDireccion())
			.direccion(entity.getDireccion())
			.idUsuario(entity.getIdUsuario())
			.build();
	}



}
