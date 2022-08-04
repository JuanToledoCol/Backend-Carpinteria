package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.UsuarioDTO;
import com.sena.webfavorites.entity.Usuario;

public class UsuarioConv extends AbstracConverter<Usuario, UsuarioDTO> {

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		return Usuario.builder().idUsuario(dto.getIdUsuario()).idRol(dto.getIdRol()).nombre(dto.getNombre())
				.apellido(dto.getApellido()).correo(dto.getCorreo()).usuario(dto.getUsuario()).pass(dto.getPass())
				.build();
	}

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		return UsuarioDTO.builder().idUsuario(entity.getIdUsuario()).idRol(entity.getIdRol()).nombre(entity.getNombre())
				.apellido(entity.getApellido()).correo(entity.getCorreo()).usuario(entity.getUsuario())
				.pass(entity.getPass()).build();
	}

}
