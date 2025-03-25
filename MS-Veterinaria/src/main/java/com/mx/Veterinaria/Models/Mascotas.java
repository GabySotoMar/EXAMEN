package com.mx.Veterinaria.Models;

import lombok.Data;

@Data
public class Mascotas {

	private Long idMascota;
	private String nombre;
	private String raza;
	private int edad;
	private String razonCita;
	private int clienteId;
	private int responsableId;
	private int veterinariaId;

}
/*
 * CREATE TABLE MASCOTAS( ID_MASCOTA NUMBER, NOMBRE NVARCHAR2(200), RAZA
 * NVARCHAR2(100), EDAD NUMBER, RAZON_CITA NVARCHAR2(500), CLIENTE_ID NUMBER,
 * RESPONSABLE_ID NUMBER, VETERINARIA_ID NUMBER, CONSTRAINT ID_MASCOTA_PK
 * PRIMARY KEY(ID_MASCOTA)
 * 
 * 
 * { "idMascota": 1, "nombre": "LORENA GONZALES CRUZ", "raza": "AKITA", "edad":
 * 1, "razonCita": "VACUNACION", "clienteId": 1, "responsableId": 1,
 * "veterinariaId": 1
 * 
 * 
 * } );
 */