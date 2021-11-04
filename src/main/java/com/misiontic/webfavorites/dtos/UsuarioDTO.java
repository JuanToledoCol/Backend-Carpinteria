package com.misiontic.webfavorites.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {

	private Long idUsuario;
	private Long idRol;
	private String nombre;
	private String apellido;
	private String correo;
	private String usuario;
}
