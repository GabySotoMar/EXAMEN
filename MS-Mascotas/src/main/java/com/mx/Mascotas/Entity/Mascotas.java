package com.mx.Mascotas.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MASCOTAS")
@Data
public class Mascotas {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ID_MASCOTA")
	@SequenceGenerator(name = "S_ID_MASCOTA", sequenceName = "S_ID_MASCOTA", allocationSize = 1)
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
 * CREATE TABLE MASCOTAS(
    ID_MASCOTA NUMBER,
    NOMBRE NVARCHAR2(200),
    RAZA NVARCHAR2(100),
    EDAD NUMBER,
    RAZON_CITA NVARCHAR2(500),
    CLIENTE_ID NUMBER,
    RESPONSABLE_ID NUMBER,
    VETERINARIA_ID NUMBER,
    CONSTRAINT ID_MASCOTA_PK PRIMARY KEY(ID_MASCOTA)
    
    
     {
        "idMascota": 1,
        "nombre": "LORENA GONZALES CRUZ",
        "raza": "AKITA",
        "edad": 1,
        "razonCita": "VACUNACION",
        "clienteId": 1,
        "responsableId": 1,
        "veterinariaId": 1
        
        
    }
);
 */