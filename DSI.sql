---TABLAS---

---independientes---
CREATE TABLE EMPLEADO 
   (	
    CODEMPLEADO NUMBER(6,0) PRIMARY KEY, 
	NOMBRE VARCHAR2(20 BYTE) NOT NULL, 
    APELLIDO VARCHAR2(20 BYTE) NOT NULL,
	DNI VARCHAR2(20 BYTE) NOT NULL, ---UNIQUE
	CELULAR VARCHAR2(33 BYTE) NOT NULL,  ---UNIQUE
	FECNAC DATE NOT NULL, 
	CODCARGO VARCHAR2(1 BYTE) NOT NULL, 
	USUARIO VARCHAR2(20 BYTE) NOT NULL, ---UNIQUE
	CONTRASENA VARCHAR2(100 BYTE) NOT NULL
   )
CREATE TABLE PROVEEDOR
    (
    CODPROVEEDOR NUMBER(6,0) PRIMARY KEY, 
	NOMBRE VARCHAR2(20 BYTE) NOT NULL, 
	DIRECCION VARCHAR2(30 BYTE) NOT NULL, ---UNIQUE
	TELEFONO VARCHAR2(33 BYTE) NOT NULL ---UNIQUE
    )
CREATE TABLE CLIENTE
    (
    CODCLIENTE NUMBER(6,0) PRIMARY KEY,
    NOMBRE VARCHAR2(20 BYTE) NOT NULL, 
    APELLIDO VARCHAR2(20 BYTE) NOT NULL,
    DNI VARCHAR2(20 BYTE) NOT NULL, ---UNIQUE
    CELULAR VARCHAR2(33 BYTE) NOT NULL ---UNIQUE
    )
CREATE TABLE PRODUCTO
    (
    CODPRODUCTO NUMBER(6,0) PRIMARY KEY,
    NOMBRE VARCHAR2(20 BYTE) NOT NULL,  --UNIQUE
    DESCRIPCION VARCHAR2(40 BYTE) NOT NULL, 
    CANTIDAD VARCHAR2(20 BYTE) DEFAULT 0 NOT NULL
    )
---dependientes
CREATE TABLE LISTA_PRODUCTO
    (
    CODLISTAPRODUCTO NUMBER(6,0) PRIMARY KEY,
    CODPRODUCTO NUMBER(6,0) NOT NULL, --FORANEA CODPRODUCTO
    FECVENC DATE NOT NULL, 
    CODPROVEEDOR NUMBER(6,0) NOT NULL, -- FORANEA CODPROVEEDOR
    CANTIDAD VARCHAR2(20 BYTE) DEFAULT 0 NOT NULL
    )
CREATE TABLE PEDIDO
    (
    CODPEDIDO NUMBER(6,0) PRIMARY KEY,
    CODCLIENTE NUMBER(6,0) NOT NULL, --FORANEA CODCLIENTE
    CODEMPLEADO NUMBER(6,0) NOT NULL, --FORANEA CODEMPLEADO
    FECHA_ACTUAL DATE DEFAULT SYSDATE NOT NULL,
    TIPO_PAGO VARCHAR2(2 BYTE) NOT NULL, --0 es efectivo, 1 tarjeta 
    TOTAL VARCHAR2(20 BYTE) NOT NULL
    )

--.RESTRICCIONES---
ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_DNI_UNICO UNIQUE (DNI);
ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_CELULAR_UNICO UNIQUE (CELULAR);
ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_USUARIO_UNICO UNIQUE (USUARIO);

ALTER TABLE PROVEEDOR ADD CONSTRAINT PROVEEDOR_DIRECCION_UNICO UNIQUE (DIRECCION);
ALTER TABLE PROVEEDOR ADD CONSTRAINT PROVEEDOR_TELEFONO_UNICO UNIQUE (TELEFONO);

ALTER TABLE CLIENTE ADD CONSTRAINT CLIENTE_DNI_UNICO UNIQUE (DNI);
ALTER TABLE CLIENTE ADD CONSTRAINT CLIENTE_CELULAR_UNICO UNIQUE (CELULAR);

ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_NOMBRE_UNICO UNIQUE (NOMBRE);

ALTER TABLE LISTA_PRODUCTO ADD FOREIGN KEY (CODPRODUCTO) REFERENCES PRODUCTO(CODPRODUCTO);
ALTER TABLE LISTA_PRODUCTO ADD FOREIGN KEY (CODPROVEEDOR) REFERENCES PROVEEDOR(CODPROVEEDOR);

ALTER TABLE PEDIDO ADD FOREIGN KEY (CODCLIENTE) REFERENCES CLIENTE(CODCLIENTE);
ALTER TABLE PEDIDO ADD FOREIGN KEY (CODEMPLEADO) REFERENCES EMPLEADO(CODEMPLEADO);


---INSERTS---
Insert into EMPLEADO (CODEMPLEADO,NOMBRE,APELLIDO,DNI,CELULAR,FECNAC,CODCARGO,USUARIO,CONTRASENA) 
values ('1','Arnold','Camacho','73254132','912284363',to_date('19/09/02 13:36:26','DD/MM/RR HH24:MI:SS'),'1','user123','12345');
Insert into EMPLEADO (CODEMPLEADO,NOMBRE,APELLIDO,DNI,CELULAR,FECNAC,CODCARGO,USUARIO,CONTRASENA) 
values ('2','Ruby','Valle','32319981','915084162',to_date('04/02/04 15:02:35','DD/MM/RR HH24:MI:SS'),'2','ruby11','qwerty');
Insert into EMPLEADO (CODEMPLEADO,NOMBRE,APELLIDO,DNI,CELULAR,FECNAC,CODCARGO,USUARIO,CONTRASENA) 
values ('3','Maria','Cisneros','87612354','911887111',to_date('01/08/03 15:02:15','DD/MM/RR HH24:MI:SS'),'3','maro11','qwerty');

INSERT INTO PROVEEDOR (CODPROVEEDOR, NOMBRE, DIRECCION, TELEFONO) 
VALUES ('1', 'Ariel', 'Av Angamos 111', '01004332');

INSERT INTO CLIENTE (CODCLIENTE, NOMBRE, APELLIDO, DNI, CELULAR) 
VALUES ('1', 'Deyvi', 'Rojas', '89876432', '951321453');

INSERT INTO PRODUCTO (CODPRODUCTO, NOMBRE, DESCRIPCION) 
VALUES ('1', 'Penicilina', 'Antibi�tico fuerte');

INSERT INTO LISTA_PRODUCTO (CODLISTAPRODUCTO, CODPRODUCTO, FECVENC, CODPROVEEDOR, CANTIDAD) 
VALUES ('1', '1', TO_DATE('2023-12-20 14:03:54', 'YYYY-MM-DD HH24:MI:SS'), '3', '5');
INSERT INTO LISTA_PRODUCTO (CODLISTAPRODUCTO, CODPRODUCTO, FECVENC, CODPROVEEDOR, CANTIDAD) 
VALUES ('2', '1', TO_DATE('2023-12-20 14:03:54', 'YYYY-MM-DD HH24:MI:SS'), '3', '12');
INSERT INTO LISTA_PRODUCTO (CODLISTAPRODUCTO, CODPRODUCTO, FECVENC, CODPROVEEDOR, CANTIDAD) 
VALUES ('3', '2', TO_DATE('2023-12-20 14:03:54', 'YYYY-MM-DD HH24:MI:SS'), '3', '4');

INSERT INTO PEDIDO (CODPEDIDO, CODCLIENTE, CODEMPLEADO, TIPO_PAGO, TOTAL) 
VALUES ('1', '1', '2', '1', '10');

update lista_producto set cantidad=5 where codproducto=1;

--selects--
select * from empleado;
select * from proveedor order by 1;
select * from cliente;
select * from producto;
select * from lista_producto;
select * from pedido;

