package com.maosan.usuario.infraestructure.entry_points;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maosan.usuario.domain.model.Usuario;
import com.maosan.usuario.domain.model.gateways.UsuarioGateway;
import com.maosan.usuario.domain.usecase.UsuarioUseCase;
import com.maosan.usuario.infraestructure.driver_adapters.jpa_repository.UsuarioData;
import com.maosan.usuario.infraestructure.mapper.MapperUsuario;

@RestController
@RequestMapping("/usuarios")
public class ApiRestUsuario {

	
	@Autowired
	private final UsuarioUseCase service;
	
	private MapperUsuario mapperUsuario;
		
	public ApiRestUsuario(UsuarioUseCase service, MapperUsuario mapperUsuario, UsuarioGateway usuarioGateway) {
		super();
		this.service = service;
		this.mapperUsuario = mapperUsuario;
	}


	@GetMapping
	public  ResponseEntity<List<UsuarioData>> listar() throws Exception{
		//return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public  ResponseEntity<UsuarioData> listarPorId(@PathVariable("id") Long id) throws Exception{

		Usuario obj = service.buscarPorId(id);
		return new ResponseEntity<UsuarioData>(mapperUsuario.toData(obj) ,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioData> registrar(@RequestBody UsuarioData usuarioData) throws Exception {
		
		Usuario obj = mapperUsuario.toUsuario(usuarioData);
		
		System.out.println("Usuario: " + usuarioData.getIdentificador());
		System.out.println("Usuario: " + usuarioData.getNombre());
				
		service.guardarUsuario(obj);  
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdentificador()).toUri();
		return ResponseEntity.created(location).build();
		
	}
			
}
