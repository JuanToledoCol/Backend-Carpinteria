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

import com.misiontic.webfavorites.converters.RolConv;
import com.misiontic.webfavorites.dtos.RolDTO;
import com.misiontic.webfavorites.entity.Rol;
import com.misiontic.webfavorites.service.RolService;

@RestController
public class RolController {

	@Autowired
	private RolService rolServi;
	private RolConv converter = new RolConv();

	@GetMapping(value = "/rol")
	public ResponseEntity<List<RolDTO>> findAll() {
		List<Rol> roles = rolServi.findAll();
		List<RolDTO> rolDto = converter.toDTO(roles);
		return new ResponseEntity<>(rolDto, HttpStatus.OK);
	}

	@GetMapping(value = "/rol/{idRol}")
	public ResponseEntity<RolDTO> findById(@PathVariable("idRol") Long idRol) {
		Rol rol = rolServi.findById(idRol);
		RolDTO rolDto = converter.toDTO(rol);
		return new ResponseEntity<RolDTO>(rolDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/rol/{idRol}")
	public ResponseEntity<Void> delete(@PathVariable("idRol") Long idRol) {
		rolServi.delete(idRol);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping(value = "/rol")
	public ResponseEntity<RolDTO> create(@RequestBody RolDTO rol) {
		Rol rolN = rolServi.save(converter.toEntity(rol));
		RolDTO rolDto = converter.toDTO(rolN);
		return new ResponseEntity<RolDTO>(rolDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/rol")
	public ResponseEntity<RolDTO> udpate(@RequestBody RolDTO rol) {
		Rol rolUP = rolServi.save(converter.toEntity(rol));
		RolDTO rolDto = converter.toDTO(rolUP);
		return new ResponseEntity<RolDTO>(rolDto, HttpStatus.CREATED);
	}
}
