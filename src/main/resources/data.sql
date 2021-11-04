INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (2, 'Pedro', 'Tomet', 'prueba1@gmail.com', 'pedro12');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (3, 'Juan', 'Tole', 'prueba2@gmail.com', 'juan12');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (4, 'Tomas', 'fermin', 'prueba3@gmail.com', 'Tomas12');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (5, 'Maria', 'Motta', 'prueba4@gmail.com', 'MAria12');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (6, 'Camilo', 'Perdomo', 'prueba5@gmail.com', 'Cam12');
INSERT INTO usuarios (idrol, nombre, apellido, correo, usuario) VALUES (7, 'Sofia', 'Tomet', 'prueba6@gmail.com', 'Sof12');

INSERT INTO roles (nombre) VALUES ('Administrador');
INSERT INTO roles (nombre) VALUES ('Usuario');
INSERT INTO roles (nombre) VALUES ('Cliente');

INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (7, 2, 'Sofia', 20, 'sala1', 'sofa1.jpg', '2021-11-03');
INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (2, 1, 'Lauris', 4, 'sala2', 'sofa2.jpg', '2021-08-03');
INSERT INTO productos (idusuario, idcategoria, nombre, cantidad, descripcion, imagen, fechacreacion) VALUES (4, 3, 'Juan', 12, 'sala3', 'sofa3.jpg', '2021-12-03');