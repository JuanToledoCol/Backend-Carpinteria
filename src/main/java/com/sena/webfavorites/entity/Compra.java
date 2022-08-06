package com.sena.webfavorites.entity;

import java.time.LocalDate;

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
@Table(name = "compras")
public class Compra{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompra")
    private Long idCompra;

    @Basic(optional = false)
    @Column(name = "fechaCompra", nullable = false)
    private LocalDate fechaCompra;

    @JoinColumn(name = "idUsuario", nullable = false, referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

}
