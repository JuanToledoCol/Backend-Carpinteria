package com.misiontic.webfavorites.validators;

import com.misiontic.webfavorites.entity.Usuario;

public class UsuarioValidator {

	public static void save(Usuario usuario) {
		if(usuario.getNombre().trim().isEmpty() || usuario.getNombre() == null){
			throw new RuntimeException("El nombre esobligatorio.");
		}
		if(usuario.getApellido().trim().isEmpty() || usuario.getApellido() == null){
			throw new RuntimeException("El nombre esobligatorio.");
		}
		if(usuario.getCorreo().trim().isEmpty() || usuario.getCorreo() == null){
			throw new RuntimeException("El nombre esobligatorio.");
		}
		if(usuario.getUsuario().trim().isEmpty() || usuario.getUsuario() == null){
			throw new RuntimeException("El nombre esobligatorio.");
		}
	}
}
