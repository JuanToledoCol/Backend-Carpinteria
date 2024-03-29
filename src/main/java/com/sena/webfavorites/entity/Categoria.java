package com.sena.webfavorites.entity;


import javax.persistence.Basic;
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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Long idCategoria;

    @Column(name = "nombreCategoria", nullable = false, length = 200)
	private String nombreCategoria;

    @Column(name = "urlImagen", nullable = true, length = 200)
	private String urlImagen;

    @Column(name = "urlPagina", nullable = true, length = 200)
	private String urlPagina;


}
