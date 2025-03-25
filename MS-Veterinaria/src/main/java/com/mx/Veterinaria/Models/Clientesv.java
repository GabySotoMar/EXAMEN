package com.mx.Veterinaria.Models;

import lombok.Data;

@Data
public class Clientesv {

	private Long idCliente;
	private String nombre;
	private String direccion;
	private Long contacto;
	private int veterinariaId;

}

/*
 * "idCliente": 1, "nombre": "GABRIELA SOTO", "direccion":
 * "RET 10J PUEBLA, PUE ", "contacto": 2222334455, "veterinariaId": 1
 */