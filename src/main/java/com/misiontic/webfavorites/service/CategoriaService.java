package com.misiontic.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.webfavorites.entity.Categoria;
import com.misiontic.webfavorites.repository.CategoriaRepository;
import com.misiontic.webfavorites.validators.CategoriaValidator;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository cateRepo;
	
	public List<Categoria> findAll(){
		List<Categoria> categorias = cateRepo.findAll();
		return categorias;
	}
	
	public Categoria findById(Long idCategoria){
		Categoria categoria = cateRepo.findById(idCategoria).orElseThrow(() -> new RuntimeException("La categoria no existe"));
		return categoria;
	}
	
	@Transactional
	public void delete(Long idCategoria) {
		Categoria categoria = cateRepo.findById(idCategoria).orElseThrow(() -> new RuntimeException("La categoria no existe"));
		cateRepo.delete(categoria);
	}
	
	@Transactional
	public Categoria save(Categoria categoria) {
		CategoriaValidator.save(categoria);
		
		if(categoria.getIdCategoria() == null) {
			Categoria categoriaN = cateRepo.save(categoria);
			return categoriaN;
		}
		
		Categoria categoriaUp = cateRepo.findById(categoria.getIdCategoria()).orElseThrow(() -> new RuntimeException("La categoria no existe"));
		
		categoriaUp.setNombre(categoria.getNombre());
		
		cateRepo.save(categoriaUp);
		return categoriaUp;
	}
}
