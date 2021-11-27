package com.misiontic.webfavorites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.webfavorites.converters.RelProductoFavoritoConv;
import com.misiontic.webfavorites.dtos.RelProductoFavoritoDTO;
import com.misiontic.webfavorites.entity.RelProductoFavorito;
import com.misiontic.webfavorites.service.RelProductoFavoritoService;
import com.misiontic.webfavorites.utils.WrapperResponse;

@RestController
public class RelProductoFavoritoController {
	
	@Autowired
	private RelProductoFavoritoService relService;
	private RelProductoFavoritoConv converter = new RelProductoFavoritoConv();
	
	@GetMapping(value = "/relproducto")
	public ResponseEntity<WrapperResponse<List<RelProductoFavoritoDTO>>> findAll() {
		List<RelProductoFavorito> rel = relService.findAll();
		List<RelProductoFavoritoDTO> relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/relproducto/{idRel}")
	public ResponseEntity<WrapperResponse<RelProductoFavoritoDTO>> findById(@PathVariable("idRel") Long idRel) {
		RelProductoFavorito rel = relService.findById(idRel);
		RelProductoFavoritoDTO relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/relproducto/{idRel}")
	public ResponseEntity<?> delete(@PathVariable("idRel") Long idRel) {
		relService.delete(idRel);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/relproducto")
	public ResponseEntity<WrapperResponse<RelProductoFavoritoDTO>> create(@RequestBody RelProductoFavoritoDTO rel) {
		RelProductoFavorito relN = relService.save(converter.toEntity(rel));
		RelProductoFavoritoDTO productoDto = converter.toDTO(relN);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.CREATED);
	}
}
