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
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idproducto")
	private Long idProducto;
	
	@Column(name = "idusuario", nullable = false)
	private Long idUsuario;
	
	@Column(name= "idcategoria", nullable = false)
	private Long idCategoria;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "cantidad", nullable = false)
	private Long cantidad;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "imagen", length = 300, nullable = false)
	private String imagen;
	
	@Column(name = "fechacreacion", nullable = false)
	private LocalDateTime fechaCreacion;
	
	
}
