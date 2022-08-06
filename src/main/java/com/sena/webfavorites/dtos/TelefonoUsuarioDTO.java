package com.sena.webfavorites.dtos;

import com.sena.webfavorites.entity.Usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TelefonoUsuarioDTO {

	private Long idTelUsuario;
	private String telefono;
	private Usuario idUsuario;

}
