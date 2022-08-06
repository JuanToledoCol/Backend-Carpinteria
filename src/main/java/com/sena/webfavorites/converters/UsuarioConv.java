package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.UsuarioDTO;
import com.sena.webfavorites.entity.Usuario;

public class UsuarioConv extends AbstracConverter<Usuario, UsuarioDTO> {

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		return Usuario.builder().idUsuario(dto.getIdUsuario()).idRol(dto.getIdRol()).idTipoDocumento(dto.getIdTipoDocumento()).nombreUsuario(dto.getNombreUsuario())
				.apellidoUsuario(dto.getApellidoUsuario()).correo(dto.getCorreo()).usuario(dto.getUsuario()).clave(dto.getClave()).numeroDocumento(dto.getNumeroDocumento())
				.build();
	}

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		return UsuarioDTO.builder().idUsuario(entity.getIdUsuario()).idRol(entity.getIdRol()).idTipoDocumento(entity.getIdTipoDocumento()).nombreUsuario(entity.getNombreUsuario())
				.apellidoUsuario(entity.getApellidoUsuario()).correo(entity.getCorreo()).usuario(entity.getUsuario())
				.clave(entity.getClave()).numeroDocumento(entity.getNumeroDocumento()).build();
	}

}
