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

import com.sena.webfavorites.converters.UsuarioConv;
import com.sena.webfavorites.dtos.LoginRequestDTO;
import com.sena.webfavorites.dtos.LoginResponseDTO;
import com.sena.webfavorites.dtos.UsuarioDTO;
import com.sena.webfavorites.entity.Usuario;
import com.sena.webfavorites.service.UsuarioService;
import com.sena.webfavorites.utils.WrapperResponse;


@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuServi;
	private UsuarioConv converter = new UsuarioConv();

	@GetMapping(value = "/usuario")
	public ResponseEntity<WrapperResponse<List<UsuarioDTO>>> findAll() {
		List<Usuario> usuarios = usuServi.findAll();
		List<UsuarioDTO> usuarioDto = converter.toDTO(usuarios);
		return new WrapperResponse<>(true, "Completado", usuarioDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/usuario/{idUsuario}")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> findById(@PathVariable("idUsuario") Long idUsuario) {
		Usuario usuario = usuServi.findById(idUsuario);
		UsuarioDTO usuarioDto = converter.toDTO(usuario);
		return new WrapperResponse<>(true, "Completado", usuarioDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/usuario/{idUsuario}")
	public ResponseEntity<?> delete(@PathVariable("idUsuario") Long idUsuario) {
		usuServi.delete(idUsuario);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/usuario")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> create(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioN = usuServi.save(converter.toEntity(usuario));
		UsuarioDTO usuarioDto = converter.toDTO(usuarioN);
		return new WrapperResponse<>(true, "Completado", usuarioDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/usuario")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> update(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioUp = usuServi.save(converter.toEntity(usuario));
		UsuarioDTO usuarioDto = converter.toDTO(usuarioUp);
		return new WrapperResponse<>(true, "Completado", usuarioDto).createResponse(HttpStatus.OK);

	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> signUp(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioN = usuServi.signUp(converter.toEntity(usuario));
		UsuarioDTO usuarioDto = converter.toDTO(usuarioN);
		return new WrapperResponse<>(true, "Completado", usuarioDto).createResponse(HttpStatus.CREATED);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request) {
		LoginResponseDTO response = usuServi.login(request);
		return new WrapperResponse<>(true, "Completado", response).createResponse(HttpStatus.OK);
	}
}
