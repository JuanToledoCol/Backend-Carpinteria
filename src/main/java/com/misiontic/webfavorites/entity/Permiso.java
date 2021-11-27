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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permisos")
public class Permiso{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpermiso")
    private Long idPermiso;
    
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    
    @Column(name = "ruta", nullable = false, length = 100)
    private String ruta;
    
    @Column(name = "iconos", nullable = false, length = 100)
    private String iconos;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermiso")
    //private List<RelUsuarioPermiso> listaRelUsuarioPermiso;
    
}
