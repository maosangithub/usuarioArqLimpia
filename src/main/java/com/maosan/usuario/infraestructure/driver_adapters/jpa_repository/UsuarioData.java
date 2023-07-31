package com.maosan.usuario.infraestructure.driver_adapters.jpa_repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario_tbl")
public class UsuarioData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificador;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	private String apellido;
	private String correo;
	
	public UsuarioData() {
	
	}

	public UsuarioData(String nombre, String apellido, String correo) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	public UsuarioData(Long identificador, String nombre, String apellido, String correo) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	public Long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	 
	
}
