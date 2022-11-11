/* Tabla Roles*/
INSERT INTO roles (nombre_rol) VALUES ('admin'),('usuario'),('moderador'),('vendedor');

/* Tabla tipos De Documento*/
INSERT INTO tipos_documentos (nombretd) VALUES ('cedula'),('tarjeta id'),('pasaporte'),('cedula ext'),('contraseña');

/* Tabla usuarios*/
INSERT INTO usuarios (nombre_usuario, apellido_usuario, usuario, clave, correo, numero_documento, id_rol, id_tipo_documento)
VALUES 
('carlos','vargas','carlos01','c12345','carlos01@gmail.com',12345,1,1),
('andres','lleras','andres02','a12345','andres02@gmail.com',123456,2,3),
('juan','perez','juan03','j12345','juan03@gmail.com',1234567,4,3),
('julieta','cortes','julieta04','j123456','julieta04@gmail.com',12345678,2,4),
('pablo','ruiz','pablo05','p123456','pablo05@gmail.com',123456789,2,2);

/*  Tabla Telefonos */
INSERT INTO telefonos_usuarios (telefono, id_usuario)
VALUES (13547576,1),(23598576,2),(34598576,3),(77598576,4),(89598576,5);

/* Tabla Direcciones*/
INSERT INTO direcciones (direccion, id_usuario)
VALUES ('avenida01 #4-18',1),('avenida02 #3-12',2),
('avenida03 #2-11',3),('avenida04 #1-09',4),('avenida05 #5-08',5);

/* Tabla Categoria*/
INSERT INTO categorias (nombre_categoria, url_pagina) 
VALUES ('muebles','/muebles'),('comedores','/comedores'),('armarios','/armarios'),('salas','/salas'),('cocinas','/cocinas'),
('banos','/banos'),('cunas','/cunas'),('escritorios','/escritorios');

/* Tabla Productos*/
INSERT INTO productos (descripcion, nombre_producto, precio, stock, id_categoria, fecha_creacion_producto)
VALUES 
('fabricado de la mejor madera','mueble beigue',12000,5,1,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','mueble Noe',11000,5,1,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','mueble Fasto',14000,5,1,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','mueble mobal',8000,5,1,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','mueble Toque',10000,5,1,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','comedor imperial',15000,7,2,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','comedor fruel',11000,7,2,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','comedor Sanpo',18000,7,2,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','Armario cama',5000,4,3,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','armario Fernat',7000,4,3,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','sala monarca',20000,3,4,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','sala Prute',25000,3,4,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','sala Gues',18000,3,4,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','sala Los',16000,3,4,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','cocina real',9000,8,5,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','cocina Yuikl',7000,8,5,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','cocina mur',11000,8,5,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','baño froa',9000,8,6,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','baño pil',91000,8,6,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','baño mista',4000,8,6,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','cuna she',10000,8,7,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','cuna true',11000,8,7,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','cuna gui',14000,8,7,'2021-05-02 05:44:15'),

('fabricado de la mejor madera','escritorio Tom',10111,8,8,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','escritorio helsie',8100,8,8,'2021-05-02 05:44:15'),
('fabricado de la mejor madera','escritorio ux',9000,8,8,'2021-05-02 05:44:15');

/* Tabla Compras */
INSERT INTO compras (fecha_compra, id_usuario) 
VALUES ('2021-08-10 20:58:47',2),('2021-05-02 05:44:15',3),
('2021-06-02 07:54:09',5),('2021-03-06 12:22:05',1),('2021-02-07 11:55:33',4);

/* Tabla RelComPro*/
INSERT INTO rel_compras_productos (id_producto, id_Compra)
VALUES (5,4),(4,5),(3,2),(2,3),(1,1), (2, 1);




















