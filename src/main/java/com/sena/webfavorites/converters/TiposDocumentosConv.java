package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.TiposDocumentosDTO;
import com.sena.webfavorites.entity.TiposDocumentos;

public class TiposDocumentosConv extends AbstracConverter<TiposDocumentos, TiposDocumentosDTO> {

	@Override
	public TiposDocumentos toEntity(TiposDocumentosDTO dto) {
		return TiposDocumentos.builder()
				.idTipoDocumento(dto.getIdTipoDocumento())
				.nombreTD(dto.getNombreTD())
				.build();
	}

	@Override
	public TiposDocumentosDTO toDTO(TiposDocumentos entity) {
		return TiposDocumentosDTO.builder()
				.idTipoDocumento(entity.getIdTipoDocumento())
				.nombreTD(entity.getNombreTD())
				.build();
	}

}
