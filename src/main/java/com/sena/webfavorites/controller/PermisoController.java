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

import com.sena.webfavorites.converters.PermisoConv;
import com.sena.webfavorites.dtos.PermisoDTO;
import com.sena.webfavorites.entity.Permiso;
import com.sena.webfavorites.service.PermisoService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	private PermisoConv converter = new PermisoConv();

	@GetMapping(value = "/permiso")
	public ResponseEntity<WrapperResponse<List<PermisoDTO>>> findAll() {
		List<Permiso> permisos = permisoService.findAll();
		List<PermisoDTO> permisosDto = converter.toDTO(permisos);
		return new WrapperResponse<>(true, "Completo", permisosDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/permiso/{idPermiso}")
	public ResponseEntity<WrapperResponse<PermisoDTO>> findById(@PathVariable("idPermiso") Long idPermiso) {
		Permiso permiso = permisoService.findById(idPermiso);
		PermisoDTO permisoDto = converter.toDTO(permiso);
		return new WrapperResponse<>(true, "Completo", permisoDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/permiso/{idPermiso}")
	public ResponseEntity<?> delete(@PathVariable("idPermiso") Long idPermiso) {
		permisoService.delete(idPermiso);
		return new WrapperResponse<>(true, "Completo", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/permiso")
	public ResponseEntity<WrapperResponse<PermisoDTO>> create(@RequestBody PermisoDTO permiso) {
		Permiso permisoN = permisoService.save(converter.toEntity(permiso));
		PermisoDTO permisoDto = converter.toDTO(permisoN);
		return new WrapperResponse<>(true, "Completo", permisoDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/permiso")
	public ResponseEntity<WrapperResponse<PermisoDTO>> update(@RequestBody PermisoDTO permiso) {
		Permiso permisoUp = permisoService.save(converter.toEntity(permiso));
		PermisoDTO permisoDto = converter.toDTO(permisoUp);
		return new WrapperResponse<>(true, "Completo", permisoDto).createResponse(HttpStatus.OK);
	}
}
