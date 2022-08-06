package com.sena.webfavorites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.entity.Compra;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.CompraRepository;
import com.sena.webfavorites.validators.CompraValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepo;

	public List<Compra> findAll() {
		try {
			List<Compra> compra = compraRepo.findAll();
			return compra;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Compra findById(Long idCompra) {
		try {
			Compra compra = compraRepo.findById(idCompra)
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));
			return compra;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idCompra) {
		try {
			Compra compra = compraRepo.findById(idCompra)
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));
			compraRepo.delete(compra);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Compra save(Compra compra) {
		try {
			CompraValidator.save(compra);

			if (compra.getIdCompra() == null) {
				Compra compraN = compraRepo.save(compra);
				return compraN;
			}

			Compra compraUp = compraRepo.findById(compra.getIdCompra())
					.orElseThrow(() -> new NoDataFoundException("No existe el Producto"));

			compraUp.setIdUsuario(compra.getIdUsuario());
			compraUp.setFechaCompra(compra.getFechaCompra());

			compraRepo.save(compraUp);
			return compraUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
