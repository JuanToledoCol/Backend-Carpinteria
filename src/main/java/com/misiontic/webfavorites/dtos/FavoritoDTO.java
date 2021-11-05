package com.misiontic.webfavorites.dtos;

import java.time.LocalDateTime;

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
	private Long idUsuario;
	private Long idCliente;
	private LocalDateTime fechaAgregado;
}
