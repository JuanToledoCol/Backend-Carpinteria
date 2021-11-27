package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.RelUsuarioPermiso;

@Repository
public interface RelUsuarioPermisoRepository extends JpaRepository<RelUsuarioPermiso, Long>{

}
