
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

import com.sena.webfavorites.converters.CompraConv;
import com.sena.webfavorites.dtos.CompraDTO;
import com.sena.webfavorites.entity.Compra;
import com.sena.webfavorites.service.CompraService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class CompraController {

	@Autowired
	private CompraService compraService;
	private CompraConv converter = new CompraConv();

	@GetMapping(value = "/compra")
	public ResponseEntity<WrapperResponse<List<CompraDTO>>> findAll() {
		List<Compra> compras = compraService.findAll();
		List<CompraDTO> comprasDto = converter.toDTO(compras);
		return new WrapperResponse<>(true, "Completo", comprasDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/compra/{idCompra}")
	public ResponseEntity<WrapperResponse<CompraDTO>> findById(@PathVariable("idCompra") Long idCompra) {
		Compra compra = compraService.findById(idCompra);
		CompraDTO compraDto = converter.toDTO(compra);
		return new WrapperResponse<>(true, "Completo", compraDto).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/compra/{idCompra}")
	public ResponseEntity<?> delete(@PathVariable("idCompra") Long idCompra) {
		compraService.delete(idCompra);
		return new WrapperResponse<>(true, "Completo", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/compra")
	public ResponseEntity<WrapperResponse<CompraDTO>> create(@RequestBody CompraDTO compra) {
		Compra compraN = compraService.save(converter.toEntity(compra));
		CompraDTO compraDto = converter.toDTO(compraN);
		return new WrapperResponse<>(true, "Completo", compraDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/compra")
	public ResponseEntity<WrapperResponse<CompraDTO>> update(@RequestBody CompraDTO compra) {
		Compra compraUp = compraService.save(converter.toEntity(compra));
		CompraDTO compraDto = converter.toDTO(compraUp);
		return new WrapperResponse<>(true, "Completo", compraDto).createResponse(HttpStatus.OK);
	}

}
