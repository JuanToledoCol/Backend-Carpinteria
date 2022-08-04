package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Favorito;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.FavoritoRepository;
import com.sena.webfavorites.validators.FavoritoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FavoritoService {

	@Autowired
	private FavoritoRepository favRepo;

	public List<Favorito> findAll() {
		try {
			List<Favorito> favoritos = favRepo.findAll();
			return favoritos;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Favorito findById(Long idFavorito) {
		try {
			Favorito favorito = favRepo.findById(idFavorito)
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));
			return favorito;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idFavorito) {
		try {
			Favorito favorito = favRepo.findById(idFavorito)
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));
			favRepo.delete(favorito);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Favorito save(Favorito favorito) {
		try {
			FavoritoValidator.save(favorito);

			if (favorito.getIdFavorito() == null) {
				Favorito favoritoN = favRepo.save(favorito);
				return favoritoN;
			}

			Favorito favoritoUp = favRepo.findById(favorito.getIdFavorito())
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));

			favoritoUp.setIdCliente(favorito.getIdCliente());
			favoritoUp.setIdUsuario(favorito.getIdUsuario());
			favoritoUp.setFecha(favorito.getFecha());

			favRepo.save(favoritoUp);
			return favoritoUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
