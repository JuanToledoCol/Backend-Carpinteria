package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.CategoriaDTO;
import com.sena.webfavorites.entity.Categoria;

public class CategoriaConv extends AbstracConverter<Categoria, CategoriaDTO> {

	@Override
	public Categoria toEntity(CategoriaDTO dto) {
		return Categoria.builder().idCategoria(dto.getIdCategoria()).nombre(dto.getNombre()).build();
	}

	@Override
	public CategoriaDTO toDTO(Categoria entity) {
		return CategoriaDTO.builder().idCategoria(entity.getIdCategoria()).nombre(entity.getNombre()).build();
	}

}
