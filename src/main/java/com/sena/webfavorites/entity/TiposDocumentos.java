package com.sena.webfavorites.entity;

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
@Table(name = "tiposDocumentos")
public class TiposDocumentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoDocumento")
	private Long idTipoDocumento;

	@Column(name= "nombreTD")
	private String nombreTD;
}
