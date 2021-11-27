package com.misiontic.webfavorites.entity;

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
@Table(name = "relusuariospermisos")
public class RelUsuarioPermiso{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelusuariopermiso")
    private Long idRelUsuarioPermiso;
    
    @JoinColumn(name = "idpermiso", referencedColumnName = "idpermiso")
    @ManyToOne(optional = false)
    private Permiso idPermiso;
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

}
