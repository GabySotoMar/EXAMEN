package com.mx.Veterinaria.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Veterinaria.Dao.IVeterinariaDao;
import com.mx.Veterinaria.Entity.Veterinaria;
import com.mx.Veterinaria.FeignClient.IClientesFeign;
import com.mx.Veterinaria.FeignClient.IMascotasFeign;
import com.mx.Veterinaria.FeignClient.IResponsablesFeign;
import com.mx.Veterinaria.Models.Clientesv;
import com.mx.Veterinaria.Models.Mascotas;
import com.mx.Veterinaria.Models.Responsables;

@Service
@SuppressWarnings("unchecked")
public class VeterinariaServiceImpl implements IVeterinariaService {

	// I N Y E C C I O N D E P E N D E N C I A S
	@Autowired
	private IVeterinariaDao dao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IClientesFeign clientesFC;

	@Autowired
	private IMascotasFeign mascotasFC;

	@Autowired
	private IResponsablesFeign responsablesFC;

	// ----------------------------------------------------------------
	// -------S E R V I C I O S - D E - V E T E R I N A R I A ---------

	@Override
	public Veterinaria guardar(Veterinaria veterinaria) {
		return dao.save(veterinaria);
	}

	@Override
	public Veterinaria editar(Veterinaria veterinaria) {
		Veterinaria aux = this.buscar(veterinaria.getIdVeterinaria());
		if (aux != null) {
			return dao.save(veterinaria);
		}
		return null;
	}

	@Override
	public Veterinaria eliminar(int idVeterinaria) {
		Veterinaria aux = this.buscar(idVeterinaria);
		if (aux != null) {
			dao.deleteById(idVeterinaria);
		}
		return aux;
	}

	@Override
	public Veterinaria buscar(int idVeterinaria) {
		return dao.findById(idVeterinaria).orElse(null);
	}

	@Override
	public List<Veterinaria> listar() {
		return dao.findAll(Sort.by(Direction.DESC, "idVeterinaria"));
	}

	// ----------------------------------------------------------------
	// -------S E R V I C I O S - D E - C L I E N T E S ---------------

	// ------------ F E I G N - C L I E N T----------------------------

	public Clientesv saveClientes(Clientesv cliente) {
		return clientesFC.saveClientes(cliente);
	}

	public List<Clientesv> getClientes(int veterinariaId) {
		return clientesFC.getClientesByVeterinariaId(veterinariaId);
	}

	// ------------ R E S T - T E M P L A T E --------------------------
	public Clientesv saveClientesRT(Clientesv cliente) {
		ResponseEntity<Clientesv> response = restTemplate.postForEntity("http://Localhost:8042/Clientes", cliente,
				Clientesv.class);
		return response.getBody();
	}

	public List<Clientesv> getClientesRT(int veterinariaId) {
		return restTemplate.postForObject("http://Localhost:8042/Clientes/buscaridVeterinaria/" + veterinariaId, null,
				List.class);

	}

	// ----------------------------------------------------------------
	// -------S E R V I C I O S - D E - M A S C O T A S ---------------

	// ------------ F E I G N - C L I E N T----------------------------
	public Mascotas saveMascotas(Mascotas mascota) {
		return mascotasFC.saveMascotas(mascota);
	}

	public List<Mascotas> getMascotas(int veterinariaId) {
		return mascotasFC.getMascotasByVeterinariaId(veterinariaId);
	}

	// ------------ R E S T - T E M P L A T E --------------------------
	public Mascotas saveMascotasRT(Mascotas mascota) {
		ResponseEntity<Mascotas> response = restTemplate.postForEntity("http://localhost:8041/Mascotas", mascota,
				Mascotas.class);
		return response.getBody();
	}

	public List<Mascotas> getMascotasRT(int veterinariaId) {
		return restTemplate.postForObject("http://localhost:8041/Mascotas/buscaridVeterinaria/", +veterinariaId, null,
				List.class);
	}

	// ----------------------------------------------------------------
	// -----S E R V I C I O S - D E - R E S P O N S A B L E S----------

	// ------------ F E I G N - C L I E N T----------------------------
	public Responsables saveResponsable(Responsables responsable){
		return responsablesFC.saveResponsable(responsable);
	}
	public List<Responsables> getResponsables(int veterinariaId){
		return responsablesFC.getResponsablesByVeterinariaId(veterinariaId);
	}
	
	// ------------ R E S T - T E M P L A T E --------------------------

	public Responsables saveResponsableRT(Responsables responsable) {
		ResponseEntity<Responsables> response = restTemplate.postForEntity("http://localhost:8040/Responsables", responsable, Responsables.class);
		return response.getBody();
	}
	
	public List<Responsables> getResponsablesRT(int veterinariaId){
		return restTemplate.postForObject("http://localhost:8040/Responsables/buscaridVeterinaria/", +veterinariaId, null,
				List.class);
	}

	//--------------------------------------------------------------------
	//-- R E L A C I O N - T O D O S - L O S - M O D U L O S -------------
	//--------------------------------------------------------------------
	
	public Map<String, Object> obtenerTodosLosModulos(int veterinariaId) {

		Map<String, Object> resultado = new HashMap<>();
		
		
		Veterinaria veterinaria = this.buscar(veterinariaId);
		if(veterinaria == null) {
			resultado.put("mensaje", "La veterinaria con ID:" + veterinariaId + " no existe");
			return resultado;
		}
		
		resultado.put("Veterinaria", veterinaria);
		
		List<Clientesv> clientes = this.getClientes(veterinariaId);
		if (clientes == null || clientes.isEmpty()) {
			resultado.put("Clientes", "La veterinaria no tiene clientes");
		} else {
			resultado.put("Clientes", clientes);
		}
		
		List<Mascotas> mascotas = this.getMascotas(veterinariaId);
		if(mascotas == null || mascotas.isEmpty()) {
			resultado.put("Mascotas", "La veterinaria no tiene mascotas");
		} else {
			resultado.put("Mascotas", mascotas);
		}
		
		List<Responsables> responsables = this.getResponsables(veterinariaId);
		if(responsables == null || responsables.isEmpty()) {
			resultado.put("Responsables", "La veterinaria no tiene responsables");
		} else {
			resultado.put("Responsables", responsables);
		}
		
		return resultado;
	}
	
}// END
