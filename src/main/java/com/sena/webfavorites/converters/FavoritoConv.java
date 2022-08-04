package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.FavoritoDTO;
import com.sena.webfavorites.entity.Favorito;

public class FavoritoConv extends AbstracConverter<Favorito, FavoritoDTO>{

	@Override
	public Favorito toEntity(FavoritoDTO dto) {
		return Favorito.builder()
				.idFavorito(dto.getIdFavorito())
				.idCliente(dto.getIdCliente())
				.idUsuario(dto.getIdUsuario())
				.fecha(dto.getFecha())
				.build();
	}

	@Override
	public FavoritoDTO toDTO(Favorito entity) {
		return FavoritoDTO.builder()
		.idFavorito(entity.getIdFavorito())
		.idCliente(entity.getIdCliente())
		.idUsuario(entity.getIdUsuario())
		.fecha(entity.getFecha())
		.build();
	}

}
