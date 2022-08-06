package com.sena.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.RelComprasProductos;

@Repository
public interface RelCompraProductoRepository extends JpaRepository<RelComprasProductos, Long> {

}
