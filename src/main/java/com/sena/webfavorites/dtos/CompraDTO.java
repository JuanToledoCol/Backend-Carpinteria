package com.sena.webfavorites.dtos;

import java.time.LocalDate;

import com.sena.webfavorites.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

	private Long idCompra;
	private Usuario idUsuario;
	private LocalDate fechaCompra;
}
