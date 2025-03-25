package com.mx.Responsables.Service;

import java.util.List;

import com.mx.Responsables.Entity.Responsables;

public interface IResponsablesService {
	
	public Responsables guardar(Responsables responsable);
	
	public Responsables editar(Responsables responsable);
	
	public Responsables eliminar(Long idResponsable);
	
	public Responsables buscar(Long idResponsable);
	
	public List<Responsables> listar();

}
