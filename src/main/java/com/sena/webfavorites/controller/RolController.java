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

import com.sena.webfavorites.converters.RolConv;
import com.sena.webfavorites.dtos.RolDTO;
import com.sena.webfavorites.entity.Rol;
import com.sena.webfavorites.service.RolService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class RolController {

	@Autowired
	private RolService rolServi;
	private RolConv converter = new RolConv();

	@GetMapping(value = "/rol")
	public ResponseEntity<WrapperResponse<List<RolDTO>>> findAll() {
		List<Rol> roles = rolServi.findAll();
		List<RolDTO> rolDto = converter.toDTO(roles);
		return new WrapperResponse<>(true, "Completo", rolDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/rol/{idRol}")
	public ResponseEntity<WrapperResponse<RolDTO>> findById(@PathVariable("idRol") Long idRol) {
		Rol rol = rolServi.findById(idRol);
		RolDTO rolDto = converter.toDTO(rol);
		return new WrapperResponse<>(true, "Completo", rolDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/rol/{idRol}")
	public ResponseEntity<?> delete(@PathVariable("idRol") Long idRol) {
		rolServi.delete(idRol);
		return new WrapperResponse<>(true, "Completo", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/rol")
	public ResponseEntity<WrapperResponse<RolDTO>> create(@RequestBody RolDTO rol) {
		Rol rolN = rolServi.save(converter.toEntity(rol));
		RolDTO rolDto = converter.toDTO(rolN);
		return new WrapperResponse<>(true, "Completo", rolDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/rol")
	public ResponseEntity<WrapperResponse<RolDTO>> udpate(@RequestBody RolDTO rol) {
		Rol rolUP = rolServi.save(converter.toEntity(rol));
		RolDTO rolDto = converter.toDTO(rolUP);
		return new WrapperResponse<>(true, "Completo", rolDto).createResponse(HttpStatus.OK);
	}
}
