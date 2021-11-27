package com.misiontic.webfavorites.dtos;

import com.misiontic.webfavorites.entity.Favorito;
import com.misiontic.webfavorites.entity.Producto;
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
