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

import com.sena.webfavorites.converters.TiposDocumentosConv;
import com.sena.webfavorites.dtos.TiposDocumentosDTO;
import com.sena.webfavorites.entity.TiposDocumentos;
import com.sena.webfavorites.service.TiposDocumentosService;
import com.sena.webfavorites.utils.WrapperResponse;

@RestController
public class TiposDocumentosController {

	@Autowired
	private TiposDocumentosService tdServi;
	private TiposDocumentosConv converter = new TiposDocumentosConv();

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/tiposDocumentos")
	public ResponseEntity<WrapperResponse<List<TiposDocumentosDTO>>> findAll() {
		List<TiposDocumentos> td = tdServi.findAll();
		List<TiposDocumentosDTO> tdDto = converter.toDTO(td);
		return new WrapperResponse<>(true, "Completado", tdDto).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/tiposDocumentos/{idTipoDocumento}")
	public ResponseEntity<WrapperResponse<TiposDocumentosDTO>> findById(@PathVariable("idTipoDocumento") Long idTipoDocumento) {
		TiposDocumentos usuario = tdServi.findById(idTipoDocumento);
		TiposDocumentosDTO TiposDocumentosDTO = converter.toDTO(usuario);
		return new WrapperResponse<>(true, "Completado", TiposDocumentosDTO).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = "/tiposDocumentos/{idTipoDocumento}")
	public ResponseEntity<?> delete(@PathVariable("idTipoDocumento") Long idTipoDocumento) {
		tdServi.delete(idTipoDocumento);
		return new WrapperResponse<>(true, "Completado", null).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = "/tiposDocumentos")
	public ResponseEntity<WrapperResponse<TiposDocumentosDTO>> create(@RequestBody TiposDocumentosDTO td) {
		TiposDocumentos tdN = tdServi.save(converter.toEntity(td));
		TiposDocumentosDTO tdDto = converter.toDTO(tdN);
		return new WrapperResponse<>(true, "Completado", tdDto).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/tiposDocumentos")
	public ResponseEntity<WrapperResponse<TiposDocumentosDTO>> update(@RequestBody TiposDocumentosDTO td) {
		TiposDocumentos tdUp = tdServi.save(converter.toEntity(td));
		TiposDocumentosDTO tdDto = converter.toDTO(tdUp);
		return new WrapperResponse<>(true, "Completado", tdDto).createResponse(HttpStatus.OK);

	}

}
