package com.sena.webfavorites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webfavorites.converters.DireccionConv;
import com.sena.webfavorites.dtos.DireccionDTO;
import com.sena.webfavorites.entity.Direccion;
import com.sena.webfavorites.service.DireccionService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class DireccionController {

	@Autowired
	private DireccionService dirService;

	private DireccionConv converter = new DireccionConv();

	@GetMapping(value = "/direccion")
	public ResponseEntity<WrapperResponse<List<DireccionDTO>>> findAll() {
		List<Direccion> dir = dirService.findAll();
		List<DireccionDTO> dirDto = converter.toDTO(dir);
		return new WrapperResponse<>(true, "Completado", dirDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/direccion/{idDir}")
	public ResponseEntity<WrapperResponse<DireccionDTO>> findById(@PathVariable("idDir") Long idDir) {
		Direccion dir = dirService.findById(idDir);
		DireccionDTO dirDto = converter.toDTO(dir);
		return new WrapperResponse<>(true, "Completado", dirDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/direccion/{idDir}")
	public ResponseEntity<?> delete(@PathVariable("idDir") Long idDir) {
		dirService.delete(idDir);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/direccion")
	public ResponseEntity<WrapperResponse<DireccionDTO>> create(@RequestBody DireccionDTO dir) {
		Direccion dirN = dirService.save(converter.toEntity(dir));
		DireccionDTO dirDto = converter.toDTO(dirN);
		return new WrapperResponse<>(true, "Completado", dirDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/direccion")
	public ResponseEntity<WrapperResponse<DireccionDTO>> update(@RequestBody DireccionDTO dir) {
		Direccion dirN = dirService.save(converter.toEntity(dir));
		DireccionDTO dirDto = converter.toDTO(dirN);
		return new WrapperResponse<>(true, "Completado", dirDto).createResponse(HttpStatus.CREATED);
	}
}
