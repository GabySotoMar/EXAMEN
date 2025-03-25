package com.mx.Veterinaria.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Veterinaria.Entity.Veterinaria;

public interface IVeterinariaDao extends JpaRepository<Veterinaria, Integer> {

}
