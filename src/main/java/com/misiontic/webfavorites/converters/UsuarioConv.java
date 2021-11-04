package com.misiontic.webfavorites.converters;

import com.misiontic.webfavorites.dtos.UsuarioDTO;
import com.misiontic.webfavorites.entity.Usuario;

public class UsuarioConv extends AbstracConverter<Usuario, UsuarioDTO> {

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		return Usuario.builder().idUsuario(dto.getIdUsuario()).idRol(dto.getIdRol()).nombre(dto.getNombre())
				.apellido(dto.getApellido()).correo(dto.getCorreo()).usuario(dto.getUsuario()).build();
	}

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		return UsuarioDTO.builder().idUsuario(entity.getIdUsuario()).idRol(entity.getIdRol()).nombre(entity.getNombre())
				.apellido(entity.getApellido()).correo(entity.getCorreo()).usuario(entity.getUsuario()).build();
	}

}
