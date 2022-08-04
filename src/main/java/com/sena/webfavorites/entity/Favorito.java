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
@Table(name = "favoritos")
public class Favorito{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfavorito")
    private Long idFavorito;

    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFavorito")
    //private List<RelProductoFavorito> listaRelProductoFavorito;

    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    @JoinColumn(name = "idcliente", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idCliente;

}
