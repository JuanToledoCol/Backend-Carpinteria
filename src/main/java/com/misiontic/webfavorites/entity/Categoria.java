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
 @Table(name = "categorias")
public class Categoria {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idcategoria")
	 private Long idCategoria;
	 
	 @Column(name = "nombre", length = 200, nullable = false)
	 private String nombre;
	 
}
