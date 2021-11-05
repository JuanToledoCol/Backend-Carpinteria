package com.misiontic.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.webfavorites.entity.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long>{

}
