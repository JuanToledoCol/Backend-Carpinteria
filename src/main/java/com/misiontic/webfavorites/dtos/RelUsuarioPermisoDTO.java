package com.misiontic.webfavorites.dtos;


import com.misiontic.webfavorites.entity.Permiso;
import com.misiontic.webfavorites.entity.Usuario;

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
