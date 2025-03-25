package com.mx.Veterinaria.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Veterinaria.Models.Mascotas;

@FeignClient(name = "MS-MASCOTAS", url = "http://localhost:8041", path = "/Mascotas")
public interface IMascotasFeign {

	@PostMapping
	public Mascotas saveMascotas(@RequestBody Mascotas mascota);

	@PostMapping("/buscaridVeterinaria/{veterinariaId}")
	public List<Mascotas> getMascotasByVeterinariaId(@PathVariable int veterinariaId);
}
