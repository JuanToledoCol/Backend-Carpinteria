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
@Table(name = "telefonosUsuarios")
public class TelefonoUsuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelUsuario")
    private Long idTelUsuario;

    @Column(name = "telefono", nullable = false, length = 200)
    private String telefono;

    @JoinColumn(name = "idUsuario", nullable = false, referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

}
