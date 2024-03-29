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
    @Column(name = "idUsuario")
    private Long idUsuario;

    @JoinColumn(name = "idRol", nullable = true, referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol idRol;

    @JoinColumn(name = "idTipoDocumento", nullable = false, referencedColumnName = "idTipoDocumento")
    @ManyToOne(optional = false)
    private TiposDocumentos idTipoDocumento;

    @Column(name = "nombreUsuario", nullable = false, length = 200)
    private String nombreUsuario;

    @Column(name = "apellidoUsuario", nullable = false, length = 200)
    private String apellidoUsuario;

    @Column(name = "correo", nullable = false, length = 300, unique = true)
    private String correo;

    @Column(name = "usuario", nullable = false, length = 40, unique = true)
    private String usuario;

    @Column(name = "clave", nullable = false, length = 200)
    private String clave;

    @Column(name = "numeroDocumento", nullable = false, length = 20, unique = true)
    private int numeroDocumento;

}
