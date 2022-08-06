package com.sena.webfavorites.dtos;

import com.sena.webfavorites.entity.Usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DireccionDTO {

	private Long idDireccion;
	private String direccion;
	private Usuario idUsuario;
}
