package com.sena.webfavorites.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.webfavorites.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByusuario(String usuario);

	public Optional<Usuario> findBynumeroDocumento(Integer numdoc);

	public Optional<Usuario> findBycorreo(String correo);
}
