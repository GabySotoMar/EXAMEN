package com.mx.Mascotas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mx.Mascotas.Entity.Mascotas;
import com.mx.Mascotas.Service.MascotasServiceImpl;

@RestController
@RequestMapping("/Mascotas")
@CrossOrigin("*")
public class MascotasWS {
	
	@Autowired
	private MascotasServiceImpl service;

	// http://localhost:8041/Mascotas

	// L I S T A R
	@GetMapping
	public ResponseEntity<?> listarMascotas() {
		List<Mascotas> mascotas = service.listar();
		if (mascotas.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(mascotas);
		}
	}

	// B U S C A R
	@PostMapping("/{idMascota}")
	public ResponseEntity<?> obtenerMascota(@PathVariable Long idMascota) {
		Mascotas mascota = service.buscar(idMascota);
		if (mascota != null) {
			return ResponseEntity.ok(mascota);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// G U A R D A R
	@PostMapping
	public ResponseEntity<?> guardarMascota(@RequestBody Mascotas mascota) {
		return ResponseEntity.ok(service.guardar(mascota));
	}

	// E D I T A R
	@PutMapping
	public ResponseEntity<?> actualizarMascotas(@RequestBody Mascotas mascota) {
		Mascotas mascotasBD = service.buscar(mascota.getIdMascota());
		if (mascotasBD != null) {
			return ResponseEntity.ok(service.editar(mascota));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//  E L I M I N A R 
	@DeleteMapping("/{idMascota}")
	public ResponseEntity<?> eliminarMascota(@PathVariable Long idMascota) {
		Mascotas mascota = service.buscar(idMascota);
		if (mascota != null) {
			service.eliminar(idMascota);
			return ResponseEntity.ok(mascota);
		} else {
			return ResponseEntity.ok(mascota);
		}
	}
	
	// B U S C A R - P O R - V E T E R I N A R I A I D
		@PostMapping("/buscaridVeterinaria/{veterinariaId}")
		public List<Mascotas> buscarveterinaria(@PathVariable int veterinariaId){
			return service.buscarveterinaria(veterinariaId);
		}
		

}


