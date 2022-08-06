package com.sena.webfavorites.validators;

import com.sena.webfavorites.entity.Usuario;
import com.sena.webfavorites.exceptions.ValidateServiceException;

public class UsuarioValidator {

	public static void save(Usuario usuario) {
		if(usuario.getNombreUsuario().trim().isEmpty() || usuario.getNombreUsuario() == null || usuario.getApellidoUsuario().trim().isEmpty() || usuario.getApellidoUsuario() == null){
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		if(usuario.getCorreo().trim().isEmpty() || usuario.getCorreo() == null){
			throw new ValidateServiceException("El Correo es obligatorio.");
		}
		if(usuario.getUsuario().trim().isEmpty() || usuario.getUsuario() == null){
			throw new ValidateServiceException("El usuario es obligatorio.");
		}
		if(usuario.getClave().trim().isEmpty() || usuario.getClave() == null){
			throw new ValidateServiceException("La contaseña es obligatorio.");
		}
	}
}
