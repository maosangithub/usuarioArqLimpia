package com.maosan.usuario.infraestructure.driver_adapters.jpa_repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.maosan.usuario.domain.model.Usuario;
import com.maosan.usuario.domain.model.gateways.UsuarioGateway;
import com.maosan.usuario.infraestructure.mapper.MapperUsuario;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UsuarioDataGatewayImpl implements UsuarioGateway{

	private final MapperUsuario mapperUsuario;
	private final UsuarioDataJpaRepository repository;
	
	
	
	
	public UsuarioDataGatewayImpl(MapperUsuario mapperUsuario, UsuarioDataJpaRepository repository) {
		super();
		this.mapperUsuario = mapperUsuario;
		this.repository = repository;
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		UsuarioData data;
		data = mapperUsuario.toData(usuario);
		
		//return repository.save(data) ;
		return mapperUsuario.toUsuario(repository.save(data));
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public Usuario buscarPorId(Long id) {
		Optional<UsuarioData> usuario;
		usuario = repository.findById(id);
	
		return mapperUsuario.toUsuario(usuario.get());
	}

}
