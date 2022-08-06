package com.sena.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

}
