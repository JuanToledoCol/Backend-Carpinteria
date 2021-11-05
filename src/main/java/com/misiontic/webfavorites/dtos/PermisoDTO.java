package com.misiontic.webfavorites.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermisoDTO {
	
	private Long idPermiso;
	private String nombre;
	private String ruta;
	
}
