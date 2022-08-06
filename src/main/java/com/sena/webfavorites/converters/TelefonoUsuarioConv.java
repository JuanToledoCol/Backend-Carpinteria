package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.TelefonoUsuarioDTO;
import com.sena.webfavorites.entity.TelefonoUsuario;

public class TelefonoUsuarioConv extends AbstracConverter<TelefonoUsuario, TelefonoUsuarioDTO>{

	@Override
	public TelefonoUsuario toEntity(TelefonoUsuarioDTO dto) {
		return TelefonoUsuario.builder()
				.idTelUsuario(dto.getIdTelUsuario())
				.telefono(dto.getTelefono())
				.idUsuario(dto.getIdUsuario())
				.build();
	}

	@Override
	public TelefonoUsuarioDTO toDTO(TelefonoUsuario entity) {
		return TelefonoUsuarioDTO.builder()
				.idTelUsuario(entity.getIdTelUsuario())
				.telefono(entity.getTelefono())
				.idUsuario(entity.getIdUsuario())
				.build();
	}

}
