package com.maosan.usuario.infraestructure.mapper;

import org.springframework.stereotype.Component; 

import com.maosan.usuario.domain.model.Usuario;
import com.maosan.usuario.infraestructure.driver_adapters.jpa_repository.UsuarioData;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class MapperUsuario {

	
	
	public Usuario toUsuario(UsuarioData usuarioDatat) {
		
		return new Usuario (
				usuarioDatat.getIdentificador(),
				usuarioDatat.getNombre(),
				usuarioDatat.getApellido(),
				usuarioDatat.getCorreo()
				);
	}
	
	public UsuarioData toData(Usuario usuario) {
		return new UsuarioData (
				usuario.getIdentificador(),
				usuario.getNombre(),
				usuario.getApellido(),
				usuario.getCorreo()
				);
	}
}
