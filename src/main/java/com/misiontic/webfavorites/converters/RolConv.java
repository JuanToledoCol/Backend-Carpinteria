package com.misiontic.webfavorites.converters;

import com.misiontic.webfavorites.dtos.RolDTO;
import com.misiontic.webfavorites.entity.Rol;

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
