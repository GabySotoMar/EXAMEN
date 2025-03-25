package com.mx.Clientes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Clientes.Entity.Clientesv;
import com.mx.Clientes.Service.ClienteServiceImpl;

@RestController
@RequestMapping("/Clientes")
@CrossOrigin("*")

public class ClientesWS {

	@Autowired
	private ClienteServiceImpl service;

	// http://Localhost:8042/Clientes

	// LISTAR
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Clientesv> clientes = service.listar();

		if (clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	// BUSCAR
	@PostMapping("/{idCliente}")
	public ResponseEntity<?> buscar(@PathVariable Long idCliente) {
		Clientesv cliente = service.buscar(idCliente);
		if (cliente != null)
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// GUARDAR
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Clientesv cliente) {
		Clientesv nuevoCliente = service.guardar(cliente);
		if (nuevoCliente != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	// EDITAR
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Clientesv cliente) {
		Clientesv aux = service.buscar(cliente.getIdCliente());

		if (aux != null)
			if (service.editar(cliente) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(cliente);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// ELIMINAR
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> eliminar(@PathVariable Long idCliente) {
		Clientesv aux = service.buscar(idCliente);
		if (aux != null)
			if (service.eliminar(idCliente) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(aux);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	// B U S C A R - P O R - V E T E R I N A R I A I D
	@PostMapping("/buscaridVeterinaria/{veterinariaId}")
	public List<Clientesv> buscarveterinaria(@PathVariable int veterinariaId){
		return service.buscarveterinaria(veterinariaId);
	}	
	

}
