package com.sena.webfavorites.controller;

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

import com.sena.webfavorites.converters.RelCompraProductoConv;
import com.sena.webfavorites.dtos.RelCompraProductoDTO;
import com.sena.webfavorites.entity.RelComprasProductos;
import com.sena.webfavorites.service.RelCompraProductoService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class RelProductoFavoritoController {

	@Autowired
	private RelCompraProductoService relService;
	private RelCompraProductoConv converter = new RelCompraProductoConv();

	@GetMapping(value = "/relproducto")
	public ResponseEntity<WrapperResponse<List<RelCompraProductoDTO>>> findAll() {
		List<RelComprasProductos> rel = relService.findAll();
		List<RelCompraProductoDTO> relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/relproducto/{idRel}")
	public ResponseEntity<WrapperResponse<RelCompraProductoDTO>> findById(@PathVariable("idRel") Long idRel) {
		RelComprasProductos rel = relService.findById(idRel);
		RelCompraProductoDTO relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/relproducto/{idRel}")
	public ResponseEntity<?> delete(@PathVariable("idRel") Long idRel) {
		relService.delete(idRel);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/relproducto")
	public ResponseEntity<WrapperResponse<RelCompraProductoDTO>> create(@RequestBody RelCompraProductoDTO rel) {
		RelComprasProductos relN = relService.save(converter.toEntity(rel));
		RelCompraProductoDTO productoDto = converter.toDTO(relN);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.CREATED);
	}
}
