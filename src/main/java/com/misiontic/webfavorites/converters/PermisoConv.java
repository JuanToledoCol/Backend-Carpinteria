package com.misiontic.webfavorites.converters;

import com.misiontic.webfavorites.dtos.PermisoDTO;
import com.misiontic.webfavorites.entity.Permiso;

public class PermisoConv extends AbstracConverter<Permiso, PermisoDTO>{

	@Override
	public Permiso toEntity(PermisoDTO dto) {
		return Permiso.builder()
				.idPermiso(dto.getIdPermiso())
				.nombre(dto.getNombre())
				.ruta(dto.getRuta())
				.build();
	}

	@Override
	public PermisoDTO toDTO(Permiso entity) {
		return PermisoDTO.builder()
				.idPermiso(entity.getIdPermiso())
				.nombre(entity.getNombre())
				.ruta(entity.getRuta())
				.build();
	}

}
