package com.misiontic.webfavorites.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Rol;
import com.misiontic.webfavorites.repository.RolRepository;
import com.misiontic.webfavorites.validators.RolValidator;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepo;
	
	public List<Rol> findAll(){
		List<Rol> roles = rolRepo.findAll();
		return roles;
	}

	public Rol findById(Long idRol) {
		Rol rol = rolRepo.findById(idRol).orElseThrow(() -> new RuntimeException("No existe ese Rol"));
		return rol;
	}
	
	@Transactional
	public void delete(Long idRol) {
		Rol rol = rolRepo.findById(idRol).orElseThrow(() -> new RuntimeException("No existe ese Rol"));
		rolRepo.delete(rol);
	}
	
	@Transactional
	public Rol save(Rol rol) {
		RolValidator.save(rol);
		
		if(rol.getIdRol() == null) {
			Rol rolN = rolRepo.save(rol);
			return rolN;
		}
		
		Rol rolUp = rolRepo.findById(rol.getIdRol()).orElseThrow(() -> new RuntimeException("No existe ese Rol"));
		
		rolUp.setNombre(rol.getNombre());
		
		rolRepo.save(rolUp);
		
		return rolUp;
	}
}
