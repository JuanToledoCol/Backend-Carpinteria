/*Consultas*/
SELECT * FROM usuarios WHERE idUsuario='1';
SELECT nombreProducto FROM productos WHERE idProducto = '3';
UPDATE categorias SET nombreCategoria = 'salotas' WHERE nombreCategoria = 'salas';
UPDATE usuarios SET clave = 'nuevaClave' WHERE idUsuario ='3';
SELECT tblRoles_idRol FROM usuarios WHERE idUsuario = '5';
SELECT * FROM compras;
SELECT * FROM compras, usuarios  WHERE compras.tblUsuarios_idUsuario = usuarios.idUsuario ;
SELECT usuarios.nombreUsuario, usuarios.usuario, roles.nombreRol FROM usuarios, roles WHERE usuarios.tblRoles_idRol = roles.idRol ORDER BY usuarios.idUsuario;
SELECT * FROM direcciones JOIN usuarios WHERE (direcciones.tblUsuario_idUsuario = usuarios.idUsuario);
INSERT INTO direcciones (direccion, tblUsuario_idUsuario) VALUES ('nUEVA direccions',2);
/*Procedimientos*/
DELIMITER $$
CREATE PROCEDURE obtenerProductosMayoresA(IN precios double)
BEGIN
    SELECT * FROM productos WHERE precio >= precios;
END$$
DELIMITER

CALL obtenerProductosMayoresA(12000);

*/---------------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE obtenerProductosStock(OUT numero int)
BEGIN
    SELECT SUM(productos.stock) numero FROM productos; 
END$$
DELIMITER

CALL obtenerProductosStock(@numero);
*/---------------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE contarUsuarios(OUT cant int)
BEGIN
    SELECT COUNT(idUsuario) AS cant FROM usuarios; 
END$$
DELIMITER

CALL contarUsuarios(@cant);
/*Funciones*/
DELIMITER //
CREATE FUNCTION insertarRol(rol VARCHAR(10)) RETURNS VARCHAR(30)
BEGIN
	DECLARE salida VARCHAR(30);

	INSERT INTO roles (nombreRol) VALUES (rol);
	SET salida = 'Se agrego exitosamente.';
	RETURN salida;
END
//

SELECT  insertarRol('videos');
*/---------------------------------------------------------------
DELIMITER //
CREATE FUNCTION contarCategorias() RETURNS int
BEGIN
	DECLARE cantCat int;

	SELECT COUNT(*) INTO cantCat FROM categorias;

	RETURN cantCat;
END
//

SELECT contarCategorias();

/*Disparador o Triggers*/

CREATE TABLE auditoria_roles(
idAudRol int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombreRolOld varchar(10) NOT NULL,
nombreRolNew varchar(10) NOT NULL,
fechaMod DATE
);

DELIMITER $$
CREATE TRIGGER aud_ModRoles BEFORE UPDATE ON roles
FOR EACH ROW
BEGIN 
	INSERT INTO auditoria_roles (nombreRolOld, nombreRolNew, fechaMod) 
	VALUES (OLD.nombreRol, NEW.nombreRol, NOW());
END$$

DELIMITER 

UPDATE roles SET nombreRol = 'modificado' WHERE nombreRol = 'admin';



