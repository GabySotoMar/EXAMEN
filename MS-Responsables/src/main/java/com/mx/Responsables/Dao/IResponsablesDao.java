package com.mx.Responsables.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Responsables.Entity.Responsables;

public interface IResponsablesDao extends JpaRepository<Responsables, Long> {
	
	public List<Responsables> findByveterinariaId(int veterinariaId);
	
}
