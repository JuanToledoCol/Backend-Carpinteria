package com.sena.webfavorites.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sena.webfavorites.entity.Usuario;
import com.sena.webfavorites.exceptions.NoDataFoundException;
import com.sena.webfavorites.repository.UsuarioRepository;
import com.sena.webfavorites.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UsuarioRepository usuRepo;
	@Autowired
	private UsuarioService usuServi;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String jwt = getJwtFromRequest(request);
			if (StringUtils.hasText(jwt) && usuServi.validateToken(jwt)) {
				String usuario = usuServi.getUsuarioFromJwt(jwt);
				
				Usuario usuarioValidate = usuRepo.findByusuario(usuario)
						.orElseThrow(() -> new NoDataFoundException("El usuario no existe"));
				
				UsuarioAuthentication userAuthentication = UsuarioAuthentication.create(usuarioValidate);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userAuthentication, null, userAuthentication.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			log.error("Error al autenticar el usuario", e);
		}
		
		filterChain.doFilter(request, response);
	} 

	public String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}
