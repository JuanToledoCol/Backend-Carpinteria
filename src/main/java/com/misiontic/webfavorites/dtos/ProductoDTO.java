package com.misiontic.webfavorites.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductoDTO {

	private Long idProducto;
	private Long idUsuario;
	private Long idCategoria;
	private String nombre;
	private Long cantidad;
	private String descripcion;
	private String imagen;
	private LocalDateTime fechaCreacion;
}
