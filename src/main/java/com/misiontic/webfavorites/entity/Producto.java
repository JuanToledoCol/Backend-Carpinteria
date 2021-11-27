package com.misiontic.webfavorites.entity;

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
    @Column(name = "idproducto")
    private Long idProducto;
    
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "cantidad", nullable = false)
    private long cantidad;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "imagen", nullable = false, length = 300)
    private String imagen;
    
    @Column(name = "fechacreacion", nullable = false)
    private LocalDate fechacreacion;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    //private List<RelProductoFavorito> listaRelProductosFavoritos;
    
    

}
