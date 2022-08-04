package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.PermisoDTO;
import com.sena.webfavorites.entity.Permiso;

public class PermisoConv extends AbstracConverter<Permiso, PermisoDTO>{

	@Override
	public Permiso toEntity(PermisoDTO dto) {
		return Permiso.builder()
				.idPermiso(dto.getIdPermiso())
				.nombre(dto.getNombre())
				.ruta(dto.getRuta())
				.iconos(dto.getIconos())
				.build();
	}

	@Override
	public PermisoDTO toDTO(Permiso entity) {
		return PermisoDTO.builder()
				.idPermiso(entity.getIdPermiso())
				.nombre(entity.getNombre())
				.ruta(entity.getRuta())
				.iconos(entity.getIconos())
				.build();
	}

}
