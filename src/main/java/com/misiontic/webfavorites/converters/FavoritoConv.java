package com.misiontic.webfavorites.converters;

import com.misiontic.webfavorites.dtos.FavoritoDTO;
import com.misiontic.webfavorites.entity.Favorito;

public class FavoritoConv extends AbstracConverter<Favorito, FavoritoDTO>{

	@Override
	public Favorito toEntity(FavoritoDTO dto) {
		return Favorito.builder()
				.idFavorito(dto.getIdFavorito())
				.idCliente(dto.getIdCliente())
				.idUsuario(dto.getIdUsuario())
				.fechaAgregado(dto.getFechaAgregado())
				.build();
	}

	@Override
	public FavoritoDTO toDTO(Favorito entity) {
		return FavoritoDTO.builder()
		.idFavorito(entity.getIdFavorito())
		.idCliente(entity.getIdCliente())
		.idUsuario(entity.getIdUsuario())
		.fechaAgregado(entity.getFechaAgregado())
		.build();
	}

}
