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

import com.misiontic.webfavorites.converters.CategoriaConv;
import com.misiontic.webfavorites.dtos.CategoriaDTO;
import com.misiontic.webfavorites.entity.Categoria;
import com.misiontic.webfavorites.service.CategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService cateService;
	private CategoriaConv converter = new CategoriaConv();

	@GetMapping(value ="/categoria")
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> categorias = cateService.findAll();
		List<CategoriaDTO> categoriasDto = converter.toDTO(categorias);
		return new ResponseEntity<List<CategoriaDTO>>(categoriasDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/categoria/{idCategoria}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable("idCategoria") Long idCategoria){
		Categoria categoria = cateService.findById(idCategoria);
		CategoriaDTO categoriaDto = converter.toDTO(categoria);
		return new ResponseEntity<CategoriaDTO>(categoriaDto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/categoria/{idCategoria}")
	public ResponseEntity<Void> delete(@PathVariable("idCategoria") Long idCategoria){
		cateService.delete(idCategoria);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/categoria")
	public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoria){
		Categoria categoriaN = cateService.save(converter.toEntity(categoria));
		CategoriaDTO categoriaDto = converter.toDTO(categoriaN);
		return new ResponseEntity<CategoriaDTO>(categoriaDto, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/categoria")
	public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoria){
		Categoria categoriaUp = cateService.save(converter.toEntity(categoria));
		CategoriaDTO categoriaDto = converter.toDTO(categoriaUp);
		return new ResponseEntity<CategoriaDTO>(categoriaDto, HttpStatus.CREATED);
	}
	
	
	
}
