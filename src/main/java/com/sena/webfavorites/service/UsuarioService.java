package com.sena.webfavorites.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.webfavorites.converters.UsuarioConv;
import com.sena.webfavorites.dtos.LoginRequestDTO;
import com.sena.webfavorites.dtos.LoginResponseDTO;
import com.sena.webfavorites.entity.Usuario;
import com.sena.webfavorites.exceptions.GeneralServiceException;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.exceptions.ValidateServiceException;
import com.sena.webfavorites.repository.UsuarioRepository;
import com.sena.webfavorites.validators.UsuarioValidator;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {

	@Value("${jwt.clave}")
	private String keySecret;

	@Autowired
	private UsuarioRepository usuRepo;
	private UsuarioConv converter = new UsuarioConv();

	public List<Usuario> findAll() {
		try {
			List<Usuario> usuarios = usuRepo.findAll();
			return usuarios;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Usuario findById(Long idUsuario) {
		try {
			Usuario usuario = usuRepo.findById(idUsuario)
					.orElseThrow(() -> new NoDataFoundException("El usuario no existe"));
			return usuario;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void delete(Long idUsuario) {
		try {
			Usuario usuario = usuRepo.findById(idUsuario)
					.orElseThrow(() -> new NoDataFoundException("El usuario no existe"));
			usuRepo.delete(usuario);
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		try {
			UsuarioValidator.save(usuario);

			if (usuario.getIdUsuario() == null) {
				Usuario usuarioN = usuRepo.save(EncoderPass(usuario));
				return usuarioN;
			}

			Usuario usuarioUp = usuRepo.findById(usuario.getIdUsuario())
					.orElseThrow(() -> new NoDataFoundException("El usuario no existe"));

			usuarioUp.setIdRol(usuario.getIdRol());
			usuarioUp.setIdTipoDocumento(usuario.getIdTipoDocumento());
			usuarioUp.setNombreUsuario(usuario.getNombreUsuario());
			usuarioUp.setApellidoUsuario(usuario.getApellidoUsuario());
			usuarioUp.setCorreo(usuario.getCorreo());
			usuarioUp.setUsuario(usuario.getUsuario());
			usuarioUp.setClave(usuario.getClave());
			usuarioUp.setNumeroDocumento(usuario.getNumeroDocumento());

			usuRepo.save(usuarioUp);

			return usuarioUp;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Usuario signUp(Usuario usuario) {
		try {
			Usuario buscarU = usuRepo.findByusuario(usuario.getUsuario()).orElse(null);
			if (buscarU != null) {
				throw new ValidateServiceException("El nombre de usuario ya existe.");
			}
			buscarU = usuRepo.findBycorreo(usuario.getCorreo()).orElse(null);
			if (buscarU != null) {
				throw new ValidateServiceException("El correo ya existe.");
			}
			buscarU = usuRepo.findBynumeroDocumento(usuario.getNumeroDocumento()).orElse(null);
			if (buscarU != null) {
				throw new ValidateServiceException("El numero de documento ya existe.");
			}
			UsuarioValidator.save(usuario);
			Usuario usuarioN = usuRepo.save(EncoderPass(usuario));
			return usuarioN;
		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public LoginResponseDTO login(LoginRequestDTO request) {
		try {
			Usuario usuario = usuRepo.findByusuario(request.getUsuario())
					.orElseThrow(() -> new ValidateServiceException("El nombre o contraseña es invalido"));

			if (!validatePass(usuario, request.getClave())) {
				throw new ValidateServiceException("El nombre o contraseña es invalido");
			}

			String token = generateToken(usuario);
			return new LoginResponseDTO(converter.toDTO(usuario), token);

		} catch (NoDataFoundException | ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public String generateToken(Usuario usuario) {
		Date now = new Date();
		Date expireDate = new Date(now.getTime() + (1000 * 60 * 60));

		return Jwts.builder()
				.setSubject(usuario.getUsuario())
				.setIssuedAt(now)
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, keySecret)
				.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(keySecret).parseClaimsJws(token);
			return true;
		} catch (UnsupportedJwtException e) {
			log.error("JWT in a particular format/configuration that does not match the format expected");
		} catch (MalformedJwtException e) {
			log.error("JWT was not correctly constructed and should be rejected.");
		} catch (SignatureException e) {
			log.error("signature or verifying an existing signature of a JWT failed.");
		}catch (ExpiredJwtException e) {
			log.error("JWT was accepted after it expired and must be rejected.");
		}
		return false;
	}

	public String getUsuarioFromJwt(String jwt) {
		try {
			return Jwts.parser().setSigningKey(keySecret).parseClaimsJws(jwt).getBody().getSubject();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ValidateServiceException("El token es inavalido");
		}
	}

	private Usuario EncoderPass(Usuario usuario) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder(16);
		usuario.setClave(passEncoder.encode(usuario.getClave())) ;
		return usuario;
	}

	private boolean validatePass(Usuario usuario, String request) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder.matches(request, usuario.getClave());
	}

}
