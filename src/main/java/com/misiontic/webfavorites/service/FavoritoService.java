package com.misiontic.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Favorito;
import com.misiontic.webfavorites.repository.FavoritoRepository;
import com.misiontic.webfavorites.validators.FavoritoValidator;

@Service
public class FavoritoService {

	@Autowired
	private FavoritoRepository favRepo;

	public List<Favorito> findAll(){
		List<Favorito> favoritos = favRepo.findAll();
		return favoritos;
	}
	
	public Favorito findById(Long idFavorito) {
		Favorito favorito = favRepo.findById(idFavorito).orElseThrow(() -> new RuntimeException("No existe el Producto"));
		return favorito;
	}
	
	@Transactional
	public void delete(Long idFavorito) {
		Favorito favorito = favRepo.findById(idFavorito).orElseThrow(() -> new RuntimeException("No existe el Producto"));
		favRepo.delete(favorito);
	}
	
	@Transactional
	public Favorito save (Favorito favorito) {
		FavoritoValidator.save(favorito);
		
		if(favorito.getIdFavorito() == null) {
			Favorito favoritoN = favRepo.save(favorito);
			return favoritoN;
		}
		
		Favorito favoritoUp = favRepo.findById(favorito.getIdFavorito()).orElseThrow(() -> new RuntimeException("No existe el Producto"));
		
		favoritoUp.setIdCliente(favorito.getIdCliente());
		favoritoUp.setIdUsuario(favorito.getIdUsuario());
		favoritoUp.setFechaAgregado(favorito.getFechaAgregado());
		
		favRepo.save(favoritoUp);
		return favoritoUp;
	}
}

