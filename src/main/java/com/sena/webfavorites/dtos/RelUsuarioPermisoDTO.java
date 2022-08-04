package com.sena.webfavorites.dtos;


import com.sena.webfavorites.entity.Permiso;
import com.sena.webfavorites.entity.Usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RelUsuarioPermisoDTO {

	private Long idRelUsuarioPermiso;
	private Permiso idPermiso;
	private Usuario idUsuario;

}
