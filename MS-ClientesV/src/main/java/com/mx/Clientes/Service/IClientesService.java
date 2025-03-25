package com.mx.Clientes.Service;

import java.util.List;

import com.mx.Clientes.Entity.Clientesv;



public interface IClientesService {
	public Clientesv guardar(Clientesv cliente);

	public Clientesv editar(Clientesv cliente);

	public Clientesv eliminar(Long idCliente);

	public Clientesv buscar(Long idCliente);

	public List<Clientesv> listar();

	
}
