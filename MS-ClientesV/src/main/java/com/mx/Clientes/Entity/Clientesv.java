package com.mx.Clientes.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTESV")
@Data
public class Clientesv{
	
	@Id
	private Long idCliente;
	private String nombre;
	private String direccion;
	private Long contacto;
	private int veterinariaId;

}

/*
 * 		"idCliente": 1,
        "nombre": "GABRIELA SOTO",
        "direccion": "RET 10J PUEBLA, PUE ",
        "contacto": 2222334455,
        "veterinariaId": 1
*/