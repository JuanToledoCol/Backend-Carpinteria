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

import com.sena.webfavorites.converters.CategoriaConv;
import com.sena.webfavorites.dtos.CategoriaDTO;
import com.sena.webfavorites.entity.Categoria;
import com.sena.webfavorites.service.CategoriaService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService cateService;
	private CategoriaConv converter = new CategoriaConv();

	@GetMapping(value ="/categoria")
	public ResponseEntity<WrapperResponse<List<CategoriaDTO>>> findAll(){
		List<Categoria> categorias = cateService.findAll();
		List<CategoriaDTO> categoriasDto = converter.toDTO(categorias);
		return new WrapperResponse<>(true, "Completo", categoriasDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/categoria/{idCategoria}")
	public ResponseEntity<WrapperResponse<CategoriaDTO>> findById(@PathVariable("idCategoria") Long idCategoria){
		Categoria categoria = cateService.findById(idCategoria);
		CategoriaDTO categoriaDto = converter.toDTO(categoria);
		return new WrapperResponse<>(true, "Completo", categoriaDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/categoria/{idCategoria}")
	public ResponseEntity<?> delete(@PathVariable("idCategoria") Long idCategoria){
		cateService.delete(idCategoria);
		return new WrapperResponse<>(true, "Completo", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/categoria")
	public ResponseEntity<WrapperResponse<CategoriaDTO>> create(@RequestBody CategoriaDTO categoria){
		Categoria categoriaN = cateService.save(converter.toEntity(categoria));
		CategoriaDTO categoriaDto = converter.toDTO(categoriaN);
		return new WrapperResponse<>(true, "Completo", categoriaDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/categoria")
	public ResponseEntity<WrapperResponse<CategoriaDTO>> update(@RequestBody CategoriaDTO categoria){
		Categoria categoriaUp = cateService.save(converter.toEntity(categoria));
		CategoriaDTO categoriaDto = converter.toDTO(categoriaUp);
		return new WrapperResponse<>(true, "Completo", categoriaDto).createResponse(HttpStatus.OK);
	}



}
