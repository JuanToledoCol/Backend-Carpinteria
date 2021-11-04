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

import com.misiontic.webfavorites.converters.UsuarioConv;
import com.misiontic.webfavorites.dtos.UsuarioDTO;
import com.misiontic.webfavorites.entity.Usuario;
import com.misiontic.webfavorites.service.UsuarioService;


@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuServi;
	private UsuarioConv converter = new UsuarioConv();

	@GetMapping(value = "/usuario")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> usuarios = usuServi.findAll();
		List<UsuarioDTO> usuarioDto = converter.toDTO(usuarios);
		return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
	}

	@GetMapping(value = "/usuario/{idUsuario}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("idUsuario") Long idUsuario) {
		Usuario usuario = usuServi.findById(idUsuario);
		UsuarioDTO usuarioDto = converter.toDTO(usuario);
		return new ResponseEntity<UsuarioDTO>(usuarioDto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/usuario/{idUsuario}")
	public ResponseEntity<Void> delete(@PathVariable("idUsuario") Long idUsuario) {
		usuServi.delete(idUsuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/usuario")
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioN = usuServi.save(converter.toEntity(usuario));
		UsuarioDTO usuarioDto = converter.toDTO(usuarioN);
		return new ResponseEntity<UsuarioDTO>(usuarioDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/usuario")
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuario) {
		Usuario usuarioUp = usuServi.save(converter.toEntity(usuario));
		UsuarioDTO usuarioDto = converter.toDTO(usuarioUp);
		return new ResponseEntity<UsuarioDTO>(usuarioDto, HttpStatus.OK);

	}

}
