package com.misiontic.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Permiso;
import com.misiontic.webfavorites.repository.PermisoRepository;
import com.misiontic.webfavorites.validators.PermisoValidator;

@Service
public class PermisoService {

	@Autowired
	private PermisoRepository permisoRepo;

	public List<Permiso> findAll() {
		List<Permiso> permisos = permisoRepo.findAll();
		return permisos;
	}

	public Permiso findById(Long idPermiso) {
		Permiso permiso = permisoRepo.findById(idPermiso)
				.orElseThrow(() -> new RuntimeException("El Permiso no existe"));
		return permiso;
	}

	@Transactional
	public void delete(Long idPermiso) {
		Permiso permiso = permisoRepo.findById(idPermiso)
				.orElseThrow(() -> new RuntimeException("El Permiso no existe"));
		permisoRepo.delete(permiso);
	}

	public Permiso save(Permiso permiso) {
		PermisoValidator.save(permiso);
		
		if(permiso.getIdPermiso() == null) {
			Permiso permisoN = permisoRepo.save(permiso);
			return permisoN;
		}
		
		Permiso permisoUp = permisoRepo.findById(permiso.getIdPermiso())
				.orElseThrow(() -> new RuntimeException("El Permiso no existe"));
		
		permisoUp.setNombre(permiso.getNombre());
		permisoUp.setRuta(permiso.getRuta());
		
		permisoRepo.save(permisoUp);
		return permisoUp;
	}
}
