package com.sena.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}
