package com.mx.Clientes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Clientes.Dao.IClientesDao;
import com.mx.Clientes.Entity.Clientesv;

@Service
public class ClienteServiceImpl implements IClientesService{

	@Autowired
	private IClientesDao dao;
	
	@Override
	public Clientesv guardar(Clientesv cliente) {
		// TODO Auto-generated method stub
		return dao.save(cliente);
	}

	@Override
	public Clientesv editar(Clientesv cliente) {
		Clientesv aux = this.buscar(cliente.getIdCliente());
		if(aux!=null) {
			return dao.save(cliente);
		}
		return null;
	}

	@Override
	public Clientesv eliminar(Long idCliente) {
		Clientesv aux = this.buscar(idCliente);
		if(aux!=null) {
			dao.deleteById(idCliente);
			
		}
		return aux;
	}

	@Override
	public Clientesv buscar(Long idCliente) {
		// TODO Auto-generated method stub
		return dao.findById(idCliente).orElse(null);
	}

	@Override
	public List<Clientesv> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idCliente"));
	}
	
	//METODO PERSONALIZADO BUSCAR POR TIENDA
		public List<Clientesv> buscarveterinaria(int veterinariaId){
			return dao.findByveterinariaId(veterinariaId);
		}

}
