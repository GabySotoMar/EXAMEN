package com.mx.Responsables.Controller;

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

import com.mx.Responsables.Entity.Responsables;
import com.mx.Responsables.Service.ResponsablesServiceImpl;

@RestController
@RequestMapping("/Responsables")
@CrossOrigin("*")
public class ResponsablesWS {

	@Autowired
	private ResponsablesServiceImpl service;
	
	//http://localhost:8040/Responsables
	
	// L I S T A R 
	@GetMapping
	public ResponseEntity<?> listarResponsables(){
		List<Responsables> responsables = service.listar();
		if(responsables.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(responsables);
		}
	}
	
	// B U S C A R
	@PostMapping("/{idResponsable}")
	public ResponseEntity<?> obtenerResponsable(@PathVariable Long idResponsable){
		Responsables responsable = service.buscar(idResponsable);
		if(responsable != null) {
			return ResponseEntity.ok(responsable);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// G U A R D A R
	@PostMapping
	public ResponseEntity<?> guardarResponsable(@RequestBody Responsables responsable){
		return ResponseEntity.ok(service.guardar(responsable));
	}
	
	// E D I T A R 
	@PutMapping
	public ResponseEntity<?> actualizarResponsable(@RequestBody Responsables responsable){
		Responsables responsableBD = service.buscar(responsable.getIdResponsable());
		if(responsableBD != null) {
			return ResponseEntity.ok(service.editar(responsable));	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//  E L I M I N A R 
	@DeleteMapping("/{idResponsable}")
	public ResponseEntity<?> eliminarResponsable(@PathVariable Long idResponsable){
		Responsables responsable = service.buscar(idResponsable);
		if(responsable != null) {
			service.eliminar(idResponsable);
			return ResponseEntity.ok(responsable);
		} else {
			return ResponseEntity.ok(responsable);
		}
	}
	
	// B U S C A R - P O R - V E T E R I N A R I A I D
	@PostMapping("/buscaridVeterinaria/{veterinariaId}")
	public List<Responsables> buscarveterinaria(@PathVariable int veterinariaId){
		return service.buscarveterinaria(veterinariaId);
	}
	
}
