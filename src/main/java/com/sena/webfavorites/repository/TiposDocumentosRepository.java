package com.sena.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.TiposDocumentos;

@Repository
public interface TiposDocumentosRepository extends JpaRepository<TiposDocumentos, Long>{

}
