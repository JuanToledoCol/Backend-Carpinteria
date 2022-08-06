package com.sena.webfavorites.dtos;

import java.time.LocalDate;

import com.sena.webfavorites.entity.Categoria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductoDTO {

	private Long idProducto;
	private Categoria idCategoria;
	private String nombreProducto;
	private int stock;
	private String descripcion;
	private Double precio ;
	private LocalDate fechaCreacionProducto;
}
