CREATE DATABASE carpinteriaBd;

USE carpinteriaBd;

/*tabla roles*/
CREATE TABLE roles(
idRol int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombreRol varchar(10) NOT NULL
);

/*tabla de los tipos de documentos*/
CREATE TABLE tipos_documentos(
idTipoDocumento int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombreTD varchar(10) NOT NULL
);

/*tabla de los usuarios*/
CREATE TABLE usuarios(
idUsuario int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombreUsuario varchar(30) NOT NULL,
apellidoUsuario varchar(30) NOT NULL,
usuario varchar(10) NOT NULL,
clave varchar(20) NOT NULL,
correo varchar(50) NOT NULL,
numeroDocumento int(13) NOT NULL,
tblRoles_idRol int NOT NULL,
tblTiposDocumentos_idTipoDocumento int NOT NULL
);

/*tabla telefonos de los usuarios*/
CREATE TABLE telefonos_usuarios(
idTelUsuario int NOT NULL PRIMARY KEY AUTO_INCREMENT,
telefono int(10) NOT NULL,
tblUsuario_idUsuario int
);

/*tabla direcciones*/
CREATE TABLE direcciones(
idDireccion int NOT NULL PRIMARY KEY AUTO_INCREMENT,
direccion varchar(40) NOT NULL,
tblUsuario_idUsuario int
);

/*tabla categorias de los productos*/
CREATE TABLE categorias(
idCategoria int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombreCategoria varchar(10) NOT NULL
);

/*tabla de los productos*/
CREATE TABLE productos(
idProducto int NOT NULL PRIMARY KEY AUTO_INCREMENT,
codigo int(50) NOT NULL,
descripcion text,
nombreProducto varchar(30) NOT NULL,
precio double NOT NULL,
stock int NOT NULL,
tblCategorias_idCategoria int
);

/*tabla compras*/
CREATE TABLE compras(
idCompra int NOT NULL PRIMARY KEY AUTO_INCREMENT,
fechaCompra datetime,
tblUsuarios_idUsuario int
);

/*tabla relacional de las compras y los productos*/
CREATE TABLE rel_compras_productos(
idRelComPro int NOT NULL PRIMARY KEY AUTO_INCREMENT,
tblProductos_idProducto int,
tblCompras_idCompra int
);

/*alteracion de tablas*/

/* TABLA USUARIOS */
ALTER TABLE usuarios ADD CONSTRAINT fk_usuarios_reference_roles 
FOREIGN KEY (tblRoles_idRol) REFERENCES roles (idRol) ON DELETE cascade ON UPDATE cascade;

ALTER TABLE usuarios ADD CONSTRAINT fk_usuarios_references_tiposDocumentos
FOREIGN KEY (tblTiposDocumentos_idTipoDocumento) REFERENCES tipos_documentos (idTipoDocumento)ON DELETE cascade ON UPDATE cascade;

/* TABLA TELEFONOS */
ALTER TABLE telefonos_usuarios ADD CONSTRAINT fk_telefonosUsuarios_reference_usuarios
FOREIGN KEY (tblUsuario_idUsuario) REFERENCES usuarios (idUsuario) ON UPDATE cascade;

/* TABLA DIRECCIONES */
ALTER TABLE direcciones ADD CONSTRAINT fk_direcciones_reference_usuarios
FOREIGN KEY (tblUsuario_idUsuario) REFERENCES usuarios (idUsuario) ON UPDATE cascade;

/* TABLA PRODUCTOS */
ALTER TABLE productos ADD CONSTRAINT fk_productos_reference_categorias
FOREIGN KEY (tblCategorias_idCategoria) REFERENCES categorias (idCategoria)ON UPDATE cascade;

/* TABLA COMPRAS */
ALTER TABLE compras ADD CONSTRAINT fk_compras_reference_usuarios
FOREIGN KEY (tblUsuarios_idUsuario) REFERENCES usuarios (idUsuario) ON UPDATE cascade;

/* TABLA RELACIONAL DE COMPRAS Y PRODUCTOS */
ALTER TABLE rel_compras_productos ADD CONSTRAINT fk_relComprasProductoss_reference_compras
FOREIGN KEY (tblCompras_idCompra) REFERENCES compras (idCompra) ON UPDATE cascade;

ALTER TABLE rel_compras_productos ADD CONSTRAINT fk_relComprasProductoss_reference_productos
FOREIGN KEY (tblProductos_idProducto) REFERENCES productos (idProducto) ON UPDATE cascade;










