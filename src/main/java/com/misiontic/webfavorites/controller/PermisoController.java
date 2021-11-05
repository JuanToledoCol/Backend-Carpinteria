package com.misiontic.webfavorites.controller;

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

import com.misiontic.webfavorites.converters.PermisoConv;
import com.misiontic.webfavorites.dtos.PermisoDTO;
import com.misiontic.webfavorites.entity.Permiso;
import com.misiontic.webfavorites.service.PermisoService;

@RestController
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	private PermisoConv converter = new PermisoConv();

	@GetMapping(value = "/permiso")
	public ResponseEntity<List<PermisoDTO>> findAll() {
		List<Permiso> permisos = permisoService.findAll();
		List<PermisoDTO> permisosDto = converter.toDTO(permisos);
		return new ResponseEntity<List<PermisoDTO>>(permisosDto, HttpStatus.OK);
	}

	@GetMapping(value = "/permiso/{idPermiso}")
	public ResponseEntity<PermisoDTO> findById(@PathVariable("idPermiso") Long idPermiso) {
		Permiso permiso = permisoService.findById(idPermiso);
		PermisoDTO permisoDto = converter.toDTO(permiso);
		return new ResponseEntity<PermisoDTO>(permisoDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/permiso/{idPermiso}")
	public ResponseEntity<Void> delete(@PathVariable("idPermiso") Long idPermiso) {
		permisoService.delete(idPermiso);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping(value = "/permiso")
	public ResponseEntity<PermisoDTO> create(@RequestBody PermisoDTO permiso) {
		Permiso permisoN = permisoService.save(converter.toEntity(permiso));
		PermisoDTO permisoDto = converter.toDTO(permisoN);
		return new ResponseEntity<PermisoDTO>(permisoDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/permiso")
	public ResponseEntity<PermisoDTO> update(@RequestBody PermisoDTO permiso) {
		Permiso permisoUp = permisoService.save(converter.toEntity(permiso));
		PermisoDTO permisoDto = converter.toDTO(permisoUp);
		return new ResponseEntity<PermisoDTO>(permisoDto, HttpStatus.CREATED);
	}
}
