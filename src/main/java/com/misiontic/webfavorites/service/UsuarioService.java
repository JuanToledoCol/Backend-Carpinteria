package com.misiontic.webfavorites.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Usuario;
import com.misiontic.webfavorites.repository.UsuarioRepository;
import com.misiontic.webfavorites.validators.UsuarioValidator;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuRepo;
	
	public List<Usuario> findAll(){
		List<Usuario> usuarios = usuRepo.findAll();
		return usuarios;
	}
	
	public Usuario findById(Long idUsuario) {
		Usuario usuario = usuRepo.findById(idUsuario).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		return usuario;
	}
	
	@Transactional
	public void delete(Long idUsuario) {
		Usuario usuario = usuRepo.findById(idUsuario).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		
		usuRepo.delete(usuario);
	}
	
	@Transactional
	public Usuario save(Usuario usuario) {
		UsuarioValidator.save(usuario);
		
		if(usuario.getIdUsuario() == null) {
			Usuario usuarioN = usuRepo.save(usuario);
			return usuarioN;
		}
		
		Usuario usuarioUp = usuRepo.findById(usuario.getIdUsuario()).orElseThrow(() -> new RuntimeException("El usuario no existe"));
		
		usuarioUp.setIdRol(usuario.getIdRol());
		usuarioUp.setNombre(usuario.getNombre());
		usuarioUp.setApellido(usuario.getApellido());
		usuarioUp.setCorreo(usuario.getCorreo());
		usuarioUp.setUsuario(usuario.getUsuario());
		
		usuRepo.save(usuarioUp);
		
		return usuarioUp;
	}
	
}
