package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.RolDTO;
import com.sena.webfavorites.entity.Rol;

public class RolConv extends AbstracConverter<Rol, RolDTO>{

	@Override
	public Rol toEntity(RolDTO dto) {
		return Rol.builder().idRol(dto.getIdRol()).nombre(dto.getNombre()).build();
	}

	@Override
	public RolDTO toDTO(Rol entity) {
		return RolDTO.builder().idRol(entity.getIdRol()).nombre(entity.getNombre()).build();

	}

}
