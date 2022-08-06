package com.sena.webfavorites.dtos;

import com.sena.webfavorites.entity.Rol;
import com.sena.webfavorites.entity.TiposDocumentos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {

	private Long idUsuario;
	private Rol idRol;
	private TiposDocumentos idTipoDocumento;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String correo;
	private String usuario;
	private String clave;
	private int numeroDocumento;
}
