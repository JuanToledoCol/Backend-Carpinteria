package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.CategoriaDTO;
import com.sena.webfavorites.entity.Categoria;

public class CategoriaConv extends AbstracConverter<Categoria, CategoriaDTO> {

	@Override
	public Categoria toEntity(CategoriaDTO dto) {
		return Categoria.builder().idCategoria(dto.getIdCategoria()).nombreCategoria(dto.getNombreCategoria()).build();
	}

	@Override
	public CategoriaDTO toDTO(Categoria entity) {
		return CategoriaDTO.builder().idCategoria(entity.getIdCategoria()).nombreCategoria(entity.getNombreCategoria()).build();
	}

}
