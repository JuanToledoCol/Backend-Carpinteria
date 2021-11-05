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

import com.misiontic.webfavorites.converters.FavoritoConv;
import com.misiontic.webfavorites.dtos.FavoritoDTO;
import com.misiontic.webfavorites.entity.Favorito;
import com.misiontic.webfavorites.service.FavoritoService;

@RestController
public class FavoritoController {

	@Autowired
	private FavoritoService favService;
	private FavoritoConv converter = new FavoritoConv();

	@GetMapping(value = "/favorito")
	public ResponseEntity<List<FavoritoDTO>> findAll() {
		List<Favorito> favoritos = favService.findAll();
		List<FavoritoDTO> favoritosDto = converter.toDTO(favoritos);
		return new ResponseEntity<List<FavoritoDTO>>(favoritosDto, HttpStatus.OK);
	}

	@GetMapping(value = "/favorito/{idFavorito}")
	public ResponseEntity<FavoritoDTO> findById(@PathVariable("idFavorito") Long idFavorito) {
		Favorito favorito = favService.findById(idFavorito);
		FavoritoDTO favoritoDto = converter.toDTO(favorito);
		return new ResponseEntity<FavoritoDTO>(favoritoDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/favorito/{idFavorito}")
	public ResponseEntity<Void> delete(@PathVariable("idFavorito") Long idFavorito) {
		favService.delete(idFavorito);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/favorito")
	public ResponseEntity<FavoritoDTO> create(@RequestBody FavoritoDTO favorito) {
		Favorito favoritoN = favService.save(converter.toEntity(favorito));
		FavoritoDTO favoritoDto = converter.toDTO(favoritoN);
		return new ResponseEntity<FavoritoDTO>(favoritoDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/favorito")
	public ResponseEntity<FavoritoDTO> update(@RequestBody FavoritoDTO favorito) {
		Favorito favoritoUp = favService.save(converter.toEntity(favorito));
		FavoritoDTO favoritoDto = converter.toDTO(favoritoUp);
		return new ResponseEntity<FavoritoDTO>(favoritoDto, HttpStatus.OK);
	}

}
