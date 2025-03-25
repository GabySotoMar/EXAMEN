package com.mx.Mascotas.Service;

import java.util.List;

import com.mx.Mascotas.Entity.Mascotas;

public interface IMascotaService {
	
	public Mascotas guardar(Mascotas mascota);
	
	public Mascotas editar(Mascotas mascota);
	
	public Mascotas eliminar(Long idMascota);
	
	public Mascotas buscar(Long idMascota);
	
	public List<Mascotas> listar();

}
