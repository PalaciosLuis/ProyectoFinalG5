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