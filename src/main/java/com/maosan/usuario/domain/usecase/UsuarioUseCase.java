package com.maosan.usuario.domain.usecase;

import com.maosan.usuario.domain.model.Usuario; 
import com.maosan.usuario.domain.model.gateways.UsuarioGateway;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioUseCase {

	private final UsuarioGateway usuarioGateway;
	
	
	public UsuarioUseCase(UsuarioGateway usuarioGateway) {
		super();
		this.usuarioGateway = usuarioGateway;
	}

	public Usuario guardarUsuario(Usuario usuario) throws Exception {
		if (usuario.getIdentificador() == null) {
			throw new Exception();
		}
		return usuarioGateway.guardar(usuario);
	} 
	
	public void eliminarPorId(Long id) {
		try {
			usuarioGateway.eliminar(id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Usuario buscarPorId(Long id) {
		try {
			return usuarioGateway.buscarPorId(id);
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
			return new Usuario();
		}
	}
	
}
