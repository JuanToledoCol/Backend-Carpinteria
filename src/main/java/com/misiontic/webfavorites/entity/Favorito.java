package com.misiontic.webfavorites.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "favoritos")
public class Favorito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfavorito")
	private Long idFavorito;
	
	@Column(name = "idusuario", nullable = false)
	private Long idUsuario;
	
	@Column(name = "idcliente" , nullable = false)
	private Long idCliente;
	
	@Column(name = "fechaagregado", nullable = false)
	private LocalDateTime fechaAgregado;
	
}
