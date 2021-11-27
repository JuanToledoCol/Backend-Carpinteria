package com.misiontic.webfavorites.dtos;

import java.time.LocalDate;

import com.misiontic.webfavorites.entity.Categoria;
import com.misiontic.webfavorites.entity.Usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductoDTO {

	private Long idProducto;
	private Usuario idUsuario;
	private Categoria idCategoria;
	private String nombre;
	private Long cantidad;
	private String descripcion;
	private String imagen;
	private LocalDate fechaCreacion;
}
