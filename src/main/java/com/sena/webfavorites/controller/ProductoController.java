package com.sena.webfavorites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webfavorites.converters.ProductoConv;
import com.sena.webfavorites.dtos.ProductoDTO;
import com.sena.webfavorites.entity.Producto;
import com.sena.webfavorites.service.ProductoService;
import com.sena.webfavorites.utils.WrapperResponse;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductoController {

	@Autowired
	private ProductoService produService;
	private ProductoConv converter = new ProductoConv();


	@GetMapping(value = "/producto")
	public ResponseEntity<WrapperResponse<List<ProductoDTO>>> findAll() {
		List<Producto> productos = produService.findAll();
		List<ProductoDTO> productoDto = converter.toDTO(productos);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/productoc/{nombreCategoria}")
	public ResponseEntity<WrapperResponse<List<ProductoDTO>>> findByCategoria(@PathVariable("nombreCategoria") String nombreCategoria) {
		List<Producto> productoPorCategoria = produService.findByCategoria(nombreCategoria);
		List<ProductoDTO> productoPorCategoriaDto = converter.toDTO(productoPorCategoria);
		return new WrapperResponse<>(true, "Completado", productoPorCategoriaDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/producto/{idProducto}")
	public ResponseEntity<WrapperResponse<ProductoDTO>> findById(@PathVariable("idProducto") Long idProducto) {
		Producto producto = produService.findById(idProducto);
		ProductoDTO productoDto = converter.toDTO(producto);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/producto/{idProducto}")
	public ResponseEntity<?> delete(@PathVariable("idProducto") Long idProducto) {
		produService.delete(idProducto);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/producto")
	public ResponseEntity<WrapperResponse<ProductoDTO>> create(@RequestBody ProductoDTO producto) {
		Producto productoN = produService.save(converter.toEntity(producto));
		ProductoDTO productoDto = converter.toDTO(productoN);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/producto")
	public ResponseEntity<WrapperResponse<ProductoDTO>> update(@RequestBody ProductoDTO producto) {
		Producto productoUp = produService.save(converter.toEntity(producto));
		ProductoDTO productoDto = converter.toDTO(productoUp);
		return new WrapperResponse<>(true, "Completado", productoDto).createResponse(HttpStatus.OK);
	}
}
