package com.sena.webfavorites.dtos;

import com.sena.webfavorites.entity.Favorito;
import com.sena.webfavorites.entity.Producto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RelProductoFavoritoDTO {

	private Long idRelProducto;
	private Favorito idFavorito;
	private Producto idProducto;
}
