package com.sena.webfavorites.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
	private Long idDireccion;

	@Column(name = "direccion", nullable = false, length = 40)
	private String direccion;

	@JoinColumn(name = "idUsuario", nullable = false, referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
	private Usuario idUsuario;
}
