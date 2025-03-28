CREATE TABLE RESPONSABLES(
    ID_RESPONSABLE NUMBER,
    NOMBRE NVARCHAR2(200),
    CONTACTO NUMBER,
    VETERINARIA_ID NUMBER,
    CONSTRAINT ID_RESPONSABLE_PK PRIMARY KEY(ID_RESPONSABLE)
);

CREATE SEQUENCE S_ID_RESPONSABLE
START WITH 1
INCREMENT BY 1
MAXVALUE 1000
MINVALUE 1
CYCLE;




SELECT * FROM RESPONSABLES;

//

CREATE TABLE MASCOTAS(
    ID_MASCOTA NUMBER,
    NOMBRE NVARCHAR2(200),
    RAZA NVARCHAR2(100),
    EDAD NUMBER,
    RAZON_CITA NVARCHAR2(500),
    CLIENTE_ID NUMBER,
    RESPONSABLE_ID NUMBER,
    VETERINARIA_ID NUMBER,
    CONSTRAINT ID_MASCOTA_PK PRIMARY KEY(ID_MASCOTA)
);


CREATE SEQUENCE S_ID_MASCOTA
START WITH 1
INCREMENT BY 1
MAXVALUE 1000
MINVALUE 1
CYCLE;

SELECT * FROM MASCOTAS;

COMMIT;