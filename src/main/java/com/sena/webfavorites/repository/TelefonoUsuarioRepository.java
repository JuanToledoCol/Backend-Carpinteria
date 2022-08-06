package com.sena.webfavorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.TelefonoUsuario;

@Repository
public interface TelefonoUsuarioRepository extends JpaRepository<TelefonoUsuario, Long>{

}
