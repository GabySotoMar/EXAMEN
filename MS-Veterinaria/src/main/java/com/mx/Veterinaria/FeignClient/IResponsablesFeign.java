package com.mx.Veterinaria.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Veterinaria.Models.Responsables;

@FeignClient(name = "MS-RESPONSABLES", url = "http://localhost:8040", path = "/Responsables")
public interface IResponsablesFeign {
	@PostMapping
	public Responsables saveResponsable(@RequestBody Responsables responsable);

	@PostMapping("/buscaridVeterinaria/{veterinariaId}")
	public List<Responsables> getResponsablesByVeterinariaId(@PathVariable int veterinariaId);

}
