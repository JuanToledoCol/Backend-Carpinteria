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

import com.misiontic.webfavorites.converters.RelUsuarioPermisoConv;
import com.misiontic.webfavorites.dtos.RelUsuarioPermisoDTO;
import com.misiontic.webfavorites.entity.RelUsuarioPermiso;
import com.misiontic.webfavorites.service.RelUsuarioPermisoService;
import com.misiontic.webfavorites.utils.WrapperResponse;

@RestController
public class RelUsuarioPermisoController {

	@Autowired
	private RelUsuarioPermisoService relService;
	
	private RelUsuarioPermisoConv converter = new RelUsuarioPermisoConv();
	
	@GetMapping(value = "/relusuario")
	public ResponseEntity<WrapperResponse<List<RelUsuarioPermisoDTO>>> findAll() {
		List<RelUsuarioPermiso> rel = relService.findAll();
		List<RelUsuarioPermisoDTO> relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/relusuario/{idRel}")
	public ResponseEntity<WrapperResponse<RelUsuarioPermisoDTO>> findById(@PathVariable("idRel") Long idRel) {
		RelUsuarioPermiso rel = relService.findById(idRel);
		RelUsuarioPermisoDTO relDto = converter.toDTO(rel);
		return new WrapperResponse<>(true, "Completado", relDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/relusuario/{idRel}")
	public ResponseEntity<?> delete(@PathVariable("idRel") Long idRel) {
		relService.delete(idRel);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/relusuario")
	public ResponseEntity<WrapperResponse<RelUsuarioPermisoDTO>> create(@RequestBody RelUsuarioPermisoDTO rel) {
		RelUsuarioPermiso relN = relService.save(converter.toEntity(rel));
		RelUsuarioPermisoDTO productoDto = converter.toDTO(relN);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.CREATED);
	}
}
