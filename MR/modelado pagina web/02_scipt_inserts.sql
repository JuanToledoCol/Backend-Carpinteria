INSERT INTO roles (nombre) VALUES ('Administrador');
INSERT INTO roles (nombre) VALUES ('Usuario');
INSERT INTO roles (nombre) VALUES ('Cliente');

INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (2, 'Pedro', 'Tomet', 'prueba1@gmail.com', 'pedro12', '123');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (3, 'Juan', 'Tole', 'prueba2@gmail.com', 'juan12', '456');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (2, 'Tomas', 'fermin', 'prueba3@gmail.com', 'Tomas12', '789');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (1, 'Maria', 'Motta', 'prueba4@gmail.com', 'MAria12', '098');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (1, 'Camilo', 'Perdomo', 'prueba5@gmail.com', 'Cam12', '765');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario, pass) VALUES (3, 'Sofia', 'Tomet', 'prueba6@gmail.com', 'Sof12', '432');

INSERT INTO categorias (nombre) VALUES ('Salas');
INSERT INTO categorias (nombre) VALUES ('Armarios');
INSERT INTO categorias (nombre) VALUES ('Cunas');
INSERT INTO categorias (nombre) VALUES ('Cocinas');

INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (5, 2, 'closet', 20, 'sala1', 'sofa1.jpg', '2021-11-03');
INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (2, 1, 'robusta', 4, 'sala2', 'sofa2.jpg', '2021-08-03');
INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (4, 3, 'little', 12, 'sala3', 'sofa3.jpg', '2021-12-03');

INSERT INTO permisos (nombre, ruta, iconos) VALUES ('Crear', '/crear', "fas fa-heart");
INSERT INTO permisos (nombre, ruta, iconos) VALUES ('Eliminar', '/eliminar', "fas fa-heart");
INSERT INTO permisos (nombre, ruta, iconos) VALUES ('Editar', '/editar', "fas fa-heart");
INSERT INTO permisos (nombre, ruta, iconos) VALUES ('Actualizar', '/actualizar', "fas fa-heart");

INSERT INTO favoritos (idusuario, idcliente, fecha) VALUES (1,1,'2021-11-21');
INSERT INTO favoritos (idusuario, idcliente, fecha) VALUES (2,2,'2021-11-21');
INSERT INTO favoritos (idusuario, idcliente, fecha) VALUES (3,3,'2021-11-21');
INSERT INTO favoritos (idusuario, idcliente, fecha) VALUES (4,4,'2021-11-21');

INSERT INTO relproductosfavoritos (idproducto, idfavorito) VALUES (1,3);
INSERT INTO relproductosfavoritos (idproducto, idfavorito) VALUES (2,2);
INSERT INTO relproductosfavoritos (idproducto, idfavorito) VALUES (3,4);
INSERT INTO relproductosfavoritos (idproducto, idfavorito) VALUES (1,1);



