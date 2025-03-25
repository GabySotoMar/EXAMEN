package com.mx.Mascotas.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Mascotas.Entity.Mascotas;

public interface IMascotaDao extends JpaRepository<Mascotas, Long>{

	public List<Mascotas> findByveterinariaId(int veterinariaId);
}
