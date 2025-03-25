package com.mx.Veterinaria.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Veterinaria.Models.Clientesv;

@FeignClient(name = "MS-CLIENTESV", url = "http://localhost:8042", path = "/Clientes")

public interface IClientesFeign {

	@PostMapping
	public Clientesv saveClientes(@RequestBody Clientesv cliente);

	@PostMapping("/buscaridVeterinaria/{veterinariaId}")
	public List<Clientesv> getClientesByVeterinariaId(@PathVariable int veterinariaId);

}
