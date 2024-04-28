use master
-- borrar las base de datos en caso exista
IF EXISTS(SELECT * FROM sys.sysdatabases WHERE name='BDCINERAMA')
Begin
	Alter Database BDCINERAMA
	SET SINGLE_USER WITH ROLLBACK IMMEDIATE
	DROP DATABASE BDCINERAMA
End
GO

-- crear la base de datos
CREATE DATABASE BDCINERAMA
USE BDCINERAMA

--crear las tablas

-- cinerama.rol definition
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.usuario definition
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_rol` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_unique` (`user`),
  KEY `usuario_rol_FK` (`id_rol`),
  CONSTRAINT `usuario_rol_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.compra definition
CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_compra`),
  KEY `compra_usuario_FK` (`id_usuario`),
  CONSTRAINT `compra_usuario_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.distribuidora definition
CREATE TABLE `distribuidora` (
  `id_distribuidora` int NOT NULL AUTO_INCREMENT,
  `nombre_distribuidora` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_distribuidora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.clasificacion definition
CREATE TABLE `clasificacion` (
  `id_clasificacion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_clasificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.pelicula definition
CREATE TABLE `pelicula` (
  `id_pelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `sinopsis` varchar(100) DEFAULT NULL,
  `id_distribuidora` int DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `duracion` double DEFAULT NULL,
  `puntuacion` int DEFAULT NULL,
  `is_estreno` tinyint(1) DEFAULT '1',
  `id_clasificacion` int DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_pelicula`),
  KEY `pelicula_distribuidora_FK` (`id_distribuidora`),
  KEY `pelicula_clasificacion_FK` (`id_clasificacion`),
  CONSTRAINT `pelicula_clasificacion_FK` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificacion` (`id_clasificacion`),
  CONSTRAINT `pelicula_distribuidora_FK` FOREIGN KEY (`id_distribuidora`) REFERENCES `distribuidora` (`id_distribuidora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.funcion definition
CREATE TABLE `funcion` (
  `id_funcion` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int DEFAULT NULL,
  `fecha_funcion` date DEFAULT NULL,
  `stock` int DEFAULT '200',
  `sala` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_funcion`),
  KEY `funcion_pelicula_FK` (`id_pelicula`),
  CONSTRAINT `funcion_pelicula_FK` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  CONSTRAINT `funcion_check` CHECK ((`stock` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- cinerama.entrada definition
CREATE TABLE entrada (
  `id_entrada` int NOT NULL AUTO_INCREMENT,
  `id_compra` int DEFAULT NULL,
  `id_funcion` int DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_entrada`),
  KEY `entrada_funcion_FK` (`id_funcion`),
  KEY `entrada_compra_FK` (`id_compra`),
  CONSTRAINT `entrada_compra_FK` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `entrada_funcion_FK` FOREIGN KEY (`id_funcion`) REFERENCES `funcion` (`id_funcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- insertar datos

INSERT INTO rol(id_rol, nombre_rol) VALUES(1, "admin")
INSERT INTO rol(id_rol, nombre_rol) VALUES(2, "operador")
INSERT INTO rol(id_rol, nombre_rol) VALUES(3, "cliente")
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('jorge_t', 'password', 1, 'Jorge', 'Torres', 'jorge.torres@example.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('luis_p', 'abcdef', 2, 'Luis', 'Paredes', 'luis.paredes@email.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('jose_a', 'qwerty', 2, 'Jose', 'Alvarado', 'jose.alvarado@hotmail.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('jireh_f', 'miclave', 3, 'Jireh', 'Flores', 'jireh.flores@gmail.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('matias_a', 'contraseña', 3, 'Matias', 'Albiño', 'matias.albino@example.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('gojo_s', 'satoru123', 3, 'Gojo', 'Satoru', 'gojo.satoru@example.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('son_goku', 'kamehameha', 3, 'Son', 'Goku', 'son.goku@dragonball.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('hannibal_l', 'cannibal', 3, 'Hannibal', 'Lecter', 'hannibal.lecter@example.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('indiana_j', 'adventure', 3, 'Indiana', 'Jones', 'indiana.jones@example.com');
INSERT INTO USUARIO(user, password, id_rol, nombre, apellido, email) VALUES ('forrest_g', 'runforrest', 3, 'Forrest', 'Gump', 'forrest.gump@example.com');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (4, '2024-04-01');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (5, '2024-03-15');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (6, '2024-02-28');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (7, '2024-01-10');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (8, '2024-05-20');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (9, '2024-06-03');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (10, '2024-07-12');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (4, '2024-08-28');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (5, '2024-09-05');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (6, '2024-10-19');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (7, '2024-11-23');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (8, '2024-12-07');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (9, '2025-01-15');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (10, '2025-02-03');
INSERT INTO compra(id_usuario, fecha_compra) VALUES (4, '2025-03-18');
INSERT INTO distribuidora(nombre_distribuidora) VALUES ('A24');
INSERT INTO distribuidora(nombre_distribuidora) VALUES ('Warner Bros. Pictures');
INSERT INTO distribuidora(nombre_distribuidora) VALUES ('Universal Pictures');
INSERT INTO distribuidora(nombre_distribuidora) VALUES ('Walt Disney Studios');
INSERT INTO clasificacion(descripcion) VALUES ('Todo Público');
INSERT INTO clasificacion(descripcion) VALUES ('Recomendado para mayores de 12 años');
INSERT INTO clasificacion(descripcion) VALUES ('Mayores de 14 años');
INSERT INTO clasificacion(descripcion) VALUES ('Apta para mayores de 16 años');
INSERT INTO clasificacion(descripcion) VALUES ('Mayores de 18 años');
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('El caballero de la noche', 'Batman se enfrenta al Joker en una batalla por el alma de Gotham.', 2, 'Christopher Nolan', 152.0, 9, 0, 4);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('La La Land', 'Una actriz y un músico se enamoran mientras persiguen sus sueños en Los Ángeles.', 1, 'Damien Chazelle', 128.0, 8, 0, 1);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Inception', 'Un ladrón de mente entra en los sueños de otros para robar secretos.', 2, 'Christopher Nolan', 148.0, 9, 0, 4);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('El lobo de Wall Street', 'La historia verdadera de Jordan Belfort, un corredor de bolsa de Wall Street.', 3, 'Martin Scorsese', 180.0, 8, 0, 5);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Interstellar', 'Un grupo de exploradores viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.', 2, 'Christopher Nolan', 169.0, 9, 0, 4);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Toy Story 4', 'Woody y sus amigos se embarcan en una aventura con un nuevo juguete llamado Forky.', 4, 'Josh Cooley', 100.0, 8, 0, 1);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Mad Max: Furia en el camino', 'Max se une a Furiosa para escapar de un tirano y su ejército en el desierto post-apocalíptico.', 5, 'George Miller', 120.0, 9, 0, 3);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('El origen', 'Un equipo de extractores roba secretos de las mentes de las personas mientras duermen.', 2, 'Christopher Nolan', 148.0, 9, 0, 4);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Hereditary', 'La familia Graham comienza a descubrir terribles secretos sobre su árbol genealógico después de la muerte de su abuela.', 1, 'Ari Aster', 127.0, 9, 0, 5);
INSERT INTO pelicula(titulo, sinopsis, id_distribuidora, director, duracion, puntuacion, is_estreno, id_clasificacion) VALUES ('Moonlight', 'Un joven afroamericano lucha con su identidad y su lugar en el mundo mientras crece en Miami.', 7, 'Barry Jenkins', 111.0, 9, 0, 2);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (1, '2024-04-17 15:00:00', 1, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (2, '2024-04-17 17:30:00', 2, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (3, '2024-04-17 20:00:00', 3, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (4, '2024-04-18 14:00:00', 4, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (5, '2024-04-18 16:30:00', 5, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (6, '2024-04-18 19:00:00', 1, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (7, '2024-04-19 13:00:00', 2, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (8, '2024-04-19 15:30:00', 3, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (9, '2024-04-19 18:00:00', 4, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (10, '2024-04-20 12:00:00', 5, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (1, '2024-04-17 15:00:00', 1, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (2, '2024-04-17 17:30:00', 2, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (3, '2024-04-17 20:00:00', 3, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (4, '2024-04-18 14:00:00', 4, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (5, '2024-04-18 16:30:00', 5, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (6, '2024-04-18 19:00:00', 1, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (7, '2024-04-19 13:00:00', 2, 20);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (8, '2024-04-19 15:30:00', 3, 15);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (9, '2024-04-19 18:00:00', 4, 30);
INSERT INTO funcion(id_pelicula, fecha_funcion, sala, precio) VALUES (10, '2024-04-20 12:00:00', 5, 20);
INSERT INTO entrada(id_compra, id_funcion) VALUES (1, 5);
INSERT INTO entrada(id_compra, id_funcion) VALUES (1, 5);
INSERT INTO entrada(id_compra, id_funcion) VALUES (1, 5);
INSERT INTO entrada(id_compra, id_funcion) VALUES (2, 15);
INSERT INTO entrada(id_compra, id_funcion) VALUES (3, 2);
INSERT INTO entrada(id_compra, id_funcion) VALUES (4, 11);
INSERT INTO entrada(id_compra, id_funcion) VALUES (5, 7);
INSERT INTO entrada(id_compra, id_funcion) VALUES (6, 19);
INSERT INTO entrada(id_compra, id_funcion) VALUES (7, 10);
INSERT INTO entrada(id_compra, id_funcion) VALUES (8, 10);
INSERT INTO entrada(id_compra, id_funcion) VALUES (9, 6);
INSERT INTO entrada(id_compra, id_funcion) VALUES (10, 18);
INSERT INTO entrada(id_compra, id_funcion) VALUES (1, 3);
INSERT INTO entrada(id_compra, id_funcion) VALUES (2, 14);
INSERT INTO entrada(id_compra, id_funcion) VALUES (3, 8);
INSERT INTO entrada(id_compra, id_funcion) VALUES (3, 8);
INSERT INTO entrada(id_compra, id_funcion) VALUES (4, 17);
INSERT INTO entrada(id_compra, id_funcion) VALUES (5, 1);
INSERT INTO entrada(id_compra, id_funcion) VALUES (6, 19);
INSERT INTO entrada(id_compra, id_funcion) VALUES (7, 10);
INSERT INTO entrada(id_compra, id_funcion) VALUES (8, 12);
