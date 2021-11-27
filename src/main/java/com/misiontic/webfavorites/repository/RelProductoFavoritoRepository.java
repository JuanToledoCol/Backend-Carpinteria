package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.RelProductoFavorito;

@Repository
public interface RelProductoFavoritoRepository extends JpaRepository<RelProductoFavorito, Long> {

}
