package com.misiontic.webfavorites.entity;

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
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "idrol", nullable = false)
	private Long idRol;
	
	@Column(name = "nombre", length = 200, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 200, nullable = false)
	private String apellido;
	
	@Column(name = "correo", length = 300, nullable = false)
	private String correo;
	
	@Column(name = "usuario", length = 40, nullable = false)
	private String usuario;
	
}
