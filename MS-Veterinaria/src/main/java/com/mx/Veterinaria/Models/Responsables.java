package com.mx.Veterinaria.Models;

import lombok.Data;

@Data
public class Responsables {

	private Long idResponsable;
	private String nombre;
	private Long contacto;
	private int veterinariaId;

}
/*
 * {"idResponsable": , "nombre": "LORENA MARTINEZ CRUZ", "contacto": 2223242526,
 * "veterinariaId": 1}
 */
