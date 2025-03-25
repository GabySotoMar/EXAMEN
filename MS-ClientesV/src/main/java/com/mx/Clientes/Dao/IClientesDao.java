package com.mx.Clientes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mx.Clientes.Entity.Clientesv;

public interface IClientesDao extends JpaRepository<Clientesv, Long> {
	
	public List<Clientesv> findByveterinariaId(int veterinariaId);

}
