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

import com.sena.webfavorites.converters.TelefonoUsuarioConv;
import com.sena.webfavorites.dtos.TelefonoUsuarioDTO;
import com.sena.webfavorites.entity.TelefonoUsuario;
import com.sena.webfavorites.service.TelefonoUsuarioService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class TelefonoUsuarioController {

	@Autowired
	private TelefonoUsuarioService telService;

	private TelefonoUsuarioConv converter = new TelefonoUsuarioConv();

	@GetMapping(value = "/telusuario")
	public ResponseEntity<WrapperResponse<List<TelefonoUsuarioDTO>>> findAll() {
		List<TelefonoUsuario> tel = telService.findAll();
		List<TelefonoUsuarioDTO> telDto = converter.toDTO(tel);
		return new WrapperResponse<>(true, "Completado", telDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/telusuario/{idtel}")
	public ResponseEntity<WrapperResponse<TelefonoUsuarioDTO>> findById(@PathVariable("idtel") Long idtel) {
		TelefonoUsuario tel = telService.findById(idtel);
		TelefonoUsuarioDTO telDto = converter.toDTO(tel);
		return new WrapperResponse<>(true, "Completado", telDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/telusuario/{idtel}")
	public ResponseEntity<?> delete(@PathVariable("idtel") Long idtel) {
		telService.delete(idtel);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/telusuario")
	public ResponseEntity<WrapperResponse<TelefonoUsuarioDTO>> create(@RequestBody TelefonoUsuarioDTO tel) {
		TelefonoUsuario telN = telService.save(converter.toEntity(tel));
		TelefonoUsuarioDTO telDto = converter.toDTO(telN);
		return new WrapperResponse<>(true, "Completado", telDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/telusuario")
	public ResponseEntity<WrapperResponse<TelefonoUsuarioDTO>> update(@RequestBody TelefonoUsuarioDTO tel) {
		TelefonoUsuario telN = telService.save(converter.toEntity(tel));
		TelefonoUsuarioDTO telDto = converter.toDTO(telN);
		return new WrapperResponse<>(true, "Completado", telDto).createResponse(HttpStatus.CREATED);
	}
}
