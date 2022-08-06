package com.sena.webfavorites.entity;

import java.time.LocalDate;

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
@Table(name = "productos")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @JoinColumn(name = "idCategoria", nullable = false, referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    @Column(name = "nombreProducto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false, length = 300)
    private Double precio;

    @Column(name = "fechaCreacionProducto", nullable = false)
    private LocalDate fechaCreacionProducto;




}
