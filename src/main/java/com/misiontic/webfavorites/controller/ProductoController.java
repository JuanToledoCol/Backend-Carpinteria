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

import com.misiontic.webfavorites.converters.ProductoConv;
import com.misiontic.webfavorites.dtos.ProductoDTO;
import com.misiontic.webfavorites.entity.Producto;
import com.misiontic.webfavorites.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService produService;
	private ProductoConv converter = new ProductoConv();

	@GetMapping(value = "/producto")
	public ResponseEntity<List<ProductoDTO>> findAll() {
		List<Producto> productos = produService.findAll();
		List<ProductoDTO> productoDto = converter.toDTO(productos);
		return new ResponseEntity<List<ProductoDTO>>(productoDto, HttpStatus.OK);
	}

	@GetMapping(value = "/producto/{idProducto}")
	public ResponseEntity<ProductoDTO> findById(@PathVariable("idProducto") Long idProducto) {
		Producto producto = produService.findById(idProducto);
		ProductoDTO productoDto = converter.toDTO(producto);
		return new ResponseEntity<ProductoDTO>(productoDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/producto/{idProducto}")
	public ResponseEntity<Void> delete(@PathVariable("idProducto") Long idProducto) {
		produService.delete(idProducto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping(value = "/producto")
	public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO producto) {
		Producto productoN = produService.save(converter.toEntity(producto));
		ProductoDTO productoDto = converter.toDTO(productoN);
		return new ResponseEntity<ProductoDTO>(productoDto, HttpStatus.OK);
	}

	@PutMapping(value = "/producto")
	public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO producto) {
		Producto productoUp = produService.save(converter.toEntity(producto));
		ProductoDTO productoDto = converter.toDTO(productoUp);
		return new ResponseEntity<ProductoDTO>(productoDto, HttpStatus.CREATED);
	}
}
