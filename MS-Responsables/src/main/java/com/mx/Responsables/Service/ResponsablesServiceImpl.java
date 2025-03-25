package com.mx.Responsables.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Responsables.Dao.IResponsablesDao;
import com.mx.Responsables.Entity.Responsables;

@Service
public class ResponsablesServiceImpl implements IResponsablesService{

	@Autowired
	private IResponsablesDao dao;
	
	@Override
	public Responsables guardar(Responsables responsable) {
		// TODO Auto-generated method stub
		return dao.save(responsable);
	}

	@Override
	public Responsables editar(Responsables responsable) {
		Responsables aux= this.buscar(responsable.getIdResponsable());
		if (aux!= null) {
		return dao.save(responsable);
		}
		return null;
	}

	@Override
	public Responsables eliminar(Long idResponsable) {
		Responsables aux= this.buscar(idResponsable);
		if(aux != null) {
			dao.deleteById(idResponsable);
		}
		return aux;
	}

	@Override
	public Responsables buscar(Long idResponsable) {
		// TODO Auto-generated method stub
		return dao.findById(idResponsable).orElse(null);
	}

	@Override
	public List<Responsables> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idResponsable"));
	}
	
	public List<Responsables> buscarveterinaria(int veterinariaId){
		return dao.findByveterinariaId(veterinariaId);
	}

}
