package com.maosan.usuario.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maosan.usuario.domain.model.gateways.UsuarioGateway;
import com.maosan.usuario.domain.usecase.UsuarioUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	public UsuarioUseCase getUsuarioUseCase(UsuarioGateway usuarioGateway) {
		return new UsuarioUseCase(usuarioGateway);
	}

}
