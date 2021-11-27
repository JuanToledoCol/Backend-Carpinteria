package com.misiontic.webfavorites.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RolDTO {

	private Long idRol;
	private String nombre;
}
