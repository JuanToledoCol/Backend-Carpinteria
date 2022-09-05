package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Categoria;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.CategoriaRepository;
import com.sena.webfavorites.validators.CategoriaValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cateRepo;

	public List<Categoria> findAll(){
		try {
			List<Categoria> categorias = cateRepo.findAll();
			return categorias;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Categoria findById(Long idCategoria){
		try {
			Categoria categoria = cateRepo.findById(idCategoria).orElseThrow(() -> new NoDataFoundException("La categoria no existe"));
			return categoria;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idCategoria) {
		try {
			Categoria categoria = cateRepo.findById(idCategoria).orElseThrow(() -> new NoDataFoundException("La categoria no existe"));
			cateRepo.delete(categoria);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Categoria save(Categoria categoria) {
		try {
			CategoriaValidator.save(categoria);

			if(categoria.getIdCategoria() == null) {
				categoria.setUrlPagina("/"+categoria.getNombreCategoria());
				Categoria categoriaN = cateRepo.save(categoria);
				return categoriaN;
			}

			Categoria categoriaUp = cateRepo.findById(categoria.getIdCategoria()).orElseThrow(() -> new NoDataFoundException("La categoria no existe"));

			categoriaUp.setNombreCategoria(categoria.getNombreCategoria());
			categoriaUp.setUrlImagen(categoria.getUrlImagen());
//			categoriaUp.setUrlPagina("/"+categoria.getNombreCategoria());
			System.out.print(categoriaUp);

			cateRepo.save(categoriaUp);
			return categoriaUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
