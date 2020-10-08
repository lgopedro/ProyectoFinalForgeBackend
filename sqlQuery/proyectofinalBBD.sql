
CREATE DATABASE SDI
USE SDI

--TABLA EMPLEADOS
CREATE TABLE EMPLEADOS_SDI(
usuario VARCHAR(200) PRIMARY KEY NOT NULL,
nombre VARCHAR(200) NOT NULL,
apellido VARCHAR (200) NOT NULL,
correo VARCHAR(200) UNIQUE NOT NULL,
contrasenha VARCHAR(200) NOT NULL,
esAdmin BIT NOT NULL
);

--TABLA PRODUCTOS
CREATE TABLE PRODUCTOS(
id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
nombre VARCHAR(200) NOT NULL,
marca VARCHAR(200) NOT NULL,
precio INT NOT NULL,
stock INT NOT NULL,
minimo INT NOT NULL,
categoria VARCHAR(200) NOT NULL
);

--Tabla venta
create table VENTA(
       idVenta INT primary key identity(1,1),
       idVendedor VARCHAR (200) not null,
       fechaHora datetime not null,
	   formaDePago VARCHAR(200) NOT NULL,
       total int not null,
       FOREIGN KEY (idVendedor) REFERENCES EMPLEADOS_SDI (usuario)
);

--Tabla detalle_venta
create table DETALLE_VENTA(
       id INT primary key identity,
       idVenta INT not null,
       idProducto INT not null,
	   nombreProducto VARCHAR(200),
       precio INT not null,
	   cantidad INT not null,  
       descuento INT not null,
       FOREIGN KEY (idVenta) REFERENCES VENTA (idVenta) ON DELETE CASCADE,
       FOREIGN KEY (idProducto) REFERENCES PRODUCTOS (id)
);

INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('iPhone SE 128GB', 'Apple', 489990, 100, 10 , 'Telefonía')
INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('iPhone XR 64GB', 'Apple', 589990, 120, 15 , 'Telefonía')
INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('iPhone XR 128GB', 'Apple', 649990, 120, 15 , 'Telefonía')
INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('iPhone 11 Pro 256GB', 'Apple', 1149990, 80, 8 , 'Telefonía')
INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('G8 Power 64GB', 'Motorola', 199990, 250, 20 , 'Telefonía')
INSERT INTO PRODUCTOS (nombre,marca,precio,stock,minimo,categoria)
VALUES ('Redmi Note 8 64GB', 'Xiaomi', 179990, 300, 30 , 'Telefonía')



