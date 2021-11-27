package com.misiontic.webfavorites.dtos;

import com.misiontic.webfavorites.entity.Rol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {

	private Long idUsuario;
	private Rol idRol;
	private String nombre;
	private String apellido;
	private String correo;
	private String usuario;
	private String pass;
}
