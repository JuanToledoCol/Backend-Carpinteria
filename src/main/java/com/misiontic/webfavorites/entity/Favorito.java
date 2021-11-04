package com.misiontic.webfavorites.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorito {

	private Long idFavorito;
	private Long idUsuario;
	private Long idCliente;
	private LocalDateTime fechaAgregado;
	
}
