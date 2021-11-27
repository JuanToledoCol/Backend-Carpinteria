package com.misiontic.webfavorites.converters;

import com.misiontic.webfavorites.dtos.RelUsuarioPermisoDTO;
import com.misiontic.webfavorites.entity.RelUsuarioPermiso;

public class RelUsuarioPermisoConv extends AbstracConverter<RelUsuarioPermiso, RelUsuarioPermisoDTO>{

	@Override
	public RelUsuarioPermiso toEntity(RelUsuarioPermisoDTO dto) {
		return RelUsuarioPermiso.builder()
				.idRelUsuarioPermiso(dto.getIdRelUsuarioPermiso())
				.idPermiso(dto.getIdPermiso())
				.idUsuario(dto.getIdUsuario())
				.build();
	}

	@Override
	public RelUsuarioPermisoDTO toDTO(RelUsuarioPermiso entity) {
		return RelUsuarioPermisoDTO.builder()
				.idRelUsuarioPermiso(entity.getIdRelUsuarioPermiso())
				.idPermiso(entity.getIdPermiso())
				.idUsuario(entity.getIdUsuario())
				.build();
	}

}
