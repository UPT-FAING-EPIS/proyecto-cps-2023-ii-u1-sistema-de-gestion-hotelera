-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.2.0.6576
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para dbtienda
CREATE DATABASE IF NOT EXISTS `dbtienda` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `dbtienda`;

-- Volcando estructura para tabla dbtienda.tbbolventa
CREATE TABLE IF NOT EXISTS `tbbolventa` (
  `codigo` varchar(5) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `total` decimal(20,6) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbbolventa: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbtienda.tbcargo
CREATE TABLE IF NOT EXISTS `tbcargo` (
  `id` int(11) NOT NULL,
  `cajero` varchar(50) NOT NULL DEFAULT '',
  `empventa` varchar(50) NOT NULL DEFAULT '',
  `gerente` varchar(50) NOT NULL DEFAULT '',
  `supervisor` varchar(50) NOT NULL DEFAULT '',
  `abastecimiento` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbcargo: ~2 rows (aproximadamente)
INSERT INTO `tbcargo` (`id`, `cajero`, `empventa`, `gerente`, `supervisor`, `abastecimiento`) VALUES
	(1, 'Administrador', '', '', '', ''),
	(2, 'Cliente', '', '', '', '');

-- Volcando estructura para tabla dbtienda.tbcategoria
CREATE TABLE IF NOT EXISTS `tbcategoria` (
  `idcategoria` int(11) DEFAULT NULL,
  `nombrecat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbcategoria: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbtienda.tbcliente
CREATE TABLE IF NOT EXISTS `tbcliente` (
  `dni` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbcliente: ~3 rows (aproximadamente)
INSERT INTO `tbcliente` (`dni`, `direccion`, `Telefono`, `email`) VALUES
	('1233', 'Av ciudad Nueva', '97241224', 'Dark_rey@hotmail.com'),
	('2222', 'Alto de la alianza', '97224', 'porgast@virtual.upt');

-- Volcando estructura para tabla dbtienda.tbdetallebolventa
CREATE TABLE IF NOT EXISTS `tbdetallebolventa` (
  `iddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `cantcompra` int(11) DEFAULT NULL,
  `prunitario` decimal(20,6) DEFAULT NULL,
  `importe` decimal(20,6) DEFAULT NULL,
  `fkcodpro` varchar(5) DEFAULT NULL,
  `fkcodbol` varchar(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`iddetalle`),
  KEY `FK_tbdetallebolventa_tbproducto` (`fkcodpro`),
  KEY `FK_tbdetallebolventa_tbbolventa` (`fkcodbol`),
  CONSTRAINT `FK_tbdetallebolventa_tbbolventa` FOREIGN KEY (`fkcodbol`) REFERENCES `tbbolventa` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbdetallebolventa_tbproducto` FOREIGN KEY (`fkcodpro`) REFERENCES `tbproducto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbdetallebolventa: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbtienda.tbempleado
CREATE TABLE IF NOT EXISTS `tbempleado` (
  `dni` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `clave` varchar(6) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbempleado: ~3 rows (aproximadamente)
INSERT INTO `tbempleado` (`dni`, `direccion`, `email`, `telefono`, `clave`, `estado`) VALUES
	('1212', 'Av ciudad Nueva', 'Dark_rey@hotmail.com', '97241224', '123', 'I'),
	('73071633', 'Pocollay 12', 'Edgard@upt.com', '94824492', '123455', 'I'),
	('73071634', 'Av internacional 12', 'reynaldo@upt.com', '94824494', '123456', 'A');

-- Volcando estructura para tabla dbtienda.tbproducto
CREATE TABLE IF NOT EXISTS `tbproducto` (
  `codigo` varchar(5) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `prunitario` decimal(20,6) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbproducto: ~2 rows (aproximadamente)
INSERT INTO `tbproducto` (`codigo`, `nombre`, `cantidad`, `prunitario`, `estado`) VALUES
	('11111', 'Salsa Tomate', 12, 5.000000, 'A'),
	('22222', 'Papas Fritas', 5, 12.000000, 'A');

-- Volcando estructura para tabla dbtienda.tbturno
CREATE TABLE IF NOT EXISTS `tbturno` (
  `mañana` varchar(50) DEFAULT NULL,
  `tarde` varchar(50) DEFAULT NULL,
  `noche` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='//tomas yoel';

-- Volcando datos para la tabla dbtienda.tbturno: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbtienda.tbusuario
CREATE TABLE IF NOT EXISTS `tbusuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `usuario` varchar(50) NOT NULL DEFAULT '',
  `contrasena` varchar(50) NOT NULL DEFAULT '',
  `id_cargo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tbusuario_tbcargo` (`id_cargo`),
  CONSTRAINT `FK_tbusuario_tbcargo` FOREIGN KEY (`id_cargo`) REFERENCES `tbcargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbusuario: ~5 rows (aproximadamente)
INSERT INTO `tbusuario` (`id`, `nombre`, `usuario`, `contrasena`, `id_cargo`) VALUES
	(1, 'Edgard', 'edgard@hotmail.com', '123456', 1),
	(2, 'Reynaldo', 'reynaldo@hotmail.com', '123456', 2),
	(3, 'luis', 'luis@hotmail.com', '123456', 1),
	(4, 'pepe', 'pepe@hotmail.com', '123456', 1);

-- Volcando estructura para tabla dbtienda.tbusuarios
CREATE TABLE IF NOT EXISTS `tbusuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT '',
  `correo` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbtienda.tbusuarios: ~2 rows (aproximadamente)
INSERT INTO `tbusuarios` (`id`, `nombre`, `correo`) VALUES
	(1, 'Edgard', 'Edgard@hotmail.com'),
	(2, 'Reynaldo', 'reynaldo@hotmail.com');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
