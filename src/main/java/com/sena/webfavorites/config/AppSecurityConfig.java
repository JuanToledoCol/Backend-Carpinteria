package com.sena.webfavorites.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sena.webfavorites.security.RestAuthenticationEntryPoint;
import com.sena.webfavorites.security.TokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public TokenAuthenticationFilter createTokenAuthFilter() {
		return new TokenAuthenticationFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf()
		.disable()
		.formLogin()
		.disable()
		.httpBasic()
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(new RestAuthenticationEntryPoint())
			.and().authorizeRequests().antMatchers(
					"/login",
					"/signup",
					"/producto",
					"/productoc/?",
					"/categoria",
					"/tiposDocumentos",
					"/registro"
					).permitAll().anyRequest().authenticated();

		http.addFilterBefore(createTokenAuthFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
