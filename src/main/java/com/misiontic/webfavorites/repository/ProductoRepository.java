package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
