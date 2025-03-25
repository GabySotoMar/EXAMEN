package com.mx.Veterinaria.Controller;

import java.util.List;
import java.util.Map;

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

import com.mx.Veterinaria.Entity.Veterinaria;
import com.mx.Veterinaria.Models.Clientesv;
import com.mx.Veterinaria.Models.Mascotas;
import com.mx.Veterinaria.Models.Responsables;
import com.mx.Veterinaria.Service.VeterinariaServiceImpl;

@RestController
@RequestMapping("/Veterinaria")
@CrossOrigin("*")
public class VeterinariaWS {

	@Autowired
	private VeterinariaServiceImpl service;

	// http://localhost:8043/Veterinaria
	// L I S T A R
	@GetMapping
	public ResponseEntity<?> listarVeterinarias() {
		List<Veterinaria> veterinaria = service.listar();
		if (veterinaria.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(veterinaria);
		}
	}

	// B U S C A R
	@PostMapping("/{idVeterinaria}")
	public ResponseEntity<?> obtenerVeterinaria(@PathVariable int idVeterinaria) {
		Veterinaria veterinaria = service.buscar(idVeterinaria);
		if (veterinaria != null) {
			return ResponseEntity.ok(veterinaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// G U A R D A R
	@PostMapping
	public ResponseEntity<?> guardarveterinaria(@RequestBody Veterinaria veterinaria) {
		return ResponseEntity.ok(service.guardar(veterinaria));
	}

	// E D I T A R
	@PutMapping
	public ResponseEntity<?> actualizarVeterinaria(@RequestBody Veterinaria veterinaria) {
		Veterinaria veterinariaBD = service.buscar(veterinaria.getIdVeterinaria());
		if (veterinariaBD != null) {
			return ResponseEntity.ok(service.editar(veterinaria));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// E L I M I N A R
	@DeleteMapping("/{idVeterinaria}")
	public ResponseEntity<?> eliminarVeterinaria(@PathVariable int idVeterinaria) {
		Veterinaria veterinaria = service.buscar(idVeterinaria);
		if (veterinaria != null) {
			service.eliminar(idVeterinaria);
			return ResponseEntity.ok(veterinaria);
		} else {
			return ResponseEntity.ok(veterinaria);
		}
	}

	// -------S E R V I C I O S - D E - C L I E N T E S ---------------

	// http://localhost:8043/Veterinaria/Clientes

	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientesv cliente) {
		Clientesv nuevoCliente = service.saveClientes(cliente);
		if (nuevoCliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
	}

	// http://localhost:8043/Tienda/Clientes/
	@GetMapping("Clientes/{veterinariaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int veterinariaId) {
		List<Clientesv> cliente = service.getClientes(veterinariaId);
		if (cliente.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(cliente);

	}

	// -------S E R V I C I O S - D E - M A S C O T A S ---------------

	// http://localhost:8043/Veterinaria/Mascotas
	@PostMapping("/Mascotas")
	public ResponseEntity<?> guardarmascota(@RequestBody Mascotas mascota) {
		Mascotas nuevoMascota = service.saveMascotas(mascota);
		if (nuevoMascota == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMascota);
	}

	// http://localhost:8043/Veterinaria/Mascotas/
	@GetMapping("Mascotas/{veterinariaId}")
	public ResponseEntity<?> obtenerMascotas(@PathVariable int veterinariaId) {
		List<Mascotas> mascota = service.getMascotas(veterinariaId);
		if (mascota.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(mascota);

	}

	// -----S E R V I C I O S - D E - R E S P O N S A B L E S----------
	// http://localhost:8043/Veterinaria/Responsables
	@PostMapping("/Responsables")
	public ResponseEntity<?> guardarResponsable(@RequestBody Responsables responsable) {
		Responsables nuevoResponsable = service.saveResponsable(responsable);
		if (nuevoResponsable == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoResponsable);
	}

	// http://localhost:8043/Tienda/Responsables/
	@GetMapping("Responsables/{veterinariaId}")
	public ResponseEntity<?> obtenerResponsable(@PathVariable int veterinariaId) {
		List<Responsables> responsable = service.getResponsables(veterinariaId);
		if (responsable.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(responsable);

	}
	
	//-- R E L A C I O N - T O D O S - L O S - M O D U L O S -------------
	// http://localhost:8043/Tienda/Todo/
	@GetMapping("/Todo/{veterinariaId}")
	public ResponseEntity<?> obtenerTodoslosModulos(@PathVariable int veterinariaId){
		Map<String, Object> modulos= service.obtenerTodosLosModulos(veterinariaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}
}
