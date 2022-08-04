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
public class FavoritoDTO {

	private Long idFavorito;
	private Usuario idUsuario;
	private Usuario idCliente;
	private LocalDate fecha;
}
