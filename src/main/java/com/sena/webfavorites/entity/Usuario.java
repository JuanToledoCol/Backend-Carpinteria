package com.sena.webfavorites.entity;


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
@Table(name = "usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;

    @JoinColumn(name = "idrol", nullable = false, referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol idRol;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 200)
    private String apellido;

    @Column(name = "correo", nullable = false, length = 300)
    private String correo;

    @Column(name = "usuario", nullable = false, length = 40)
    private String usuario;

    @Column(name = "pass", nullable = false, length = 100)
    private String pass;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    //private List<Favorito> listaFavoritosUsuarios;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    //private List<Favorito> listaFavoritosClientes;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    //private List<RelUsuarioPermiso> listaRelUsuariosPermisos;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    //private List<Producto> listaProductos;

}
