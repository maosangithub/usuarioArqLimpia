package com.maosan.usuario.domain.model.gateways;

import com.maosan.usuario.domain.model.Usuario;

public interface UsuarioGateway {
	
	Usuario guardar(Usuario usuario);
	void eliminar(Long id);
	Usuario buscarPorId(Long id);
	//Usuario guardar(UsuarioData usuarioData);

}

