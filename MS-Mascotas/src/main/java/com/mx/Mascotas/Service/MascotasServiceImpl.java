package com.mx.Mascotas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Mascotas.Dao.IMascotaDao;
import com.mx.Mascotas.Entity.Mascotas;

@Service
public class MascotasServiceImpl implements IMascotaService {

	@Autowired
	private IMascotaDao dao;
	
	@Override
	public Mascotas guardar(Mascotas mascota) {
		return dao.save(mascota);
	}

	@Override
	public Mascotas editar(Mascotas mascota) {
		Mascotas aux= this.buscar(mascota.getIdMascota());
		if (aux!= null) {
		return dao.save(mascota);
		}
		return null;
	}

	@Override
	public Mascotas eliminar(Long idMascota) {
		Mascotas aux= this.buscar(idMascota);
		if(aux != null) {
			dao.deleteById(idMascota);
		}
		return aux;
	}

	@Override
	public Mascotas buscar(Long idMascota) {
		
		return dao.findById(idMascota).orElse(null);
	}

	@Override
	public List<Mascotas> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idMascota"));
	}
	
	public List<Mascotas> buscarveterinaria(int veterinariaId){
		return dao.findByveterinariaId(veterinariaId);
	}
	

}
