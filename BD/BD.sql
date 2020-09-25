-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para entradaunivalle
CREATE DATABASE IF NOT EXISTS `entradaunivalle` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */;
USE `entradaunivalle`;

-- Volcando estructura para tabla entradaunivalle.entradassalidas
CREATE TABLE IF NOT EXISTS `entradassalidas` (
  `IDEntradaSalida` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date DEFAULT NULL,
  `HoraEntrada` time DEFAULT NULL,
  `HoraSalida` time DEFAULT NULL,
  `Temperatura` varchar(50) DEFAULT NULL,
  `CedulaUsuario` int(11) DEFAULT NULL,
  `CedulaPersonal` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDEntradaSalida`),
  KEY `FK_entradassalidas_usuarios` (`CedulaUsuario`),
  KEY `FK_entradassalidas_personal` (`CedulaPersonal`),
  CONSTRAINT `FK_entradassalidas_personal` FOREIGN KEY (`CedulaPersonal`) REFERENCES `personal` (`CedulaPersonal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_entradassalidas_usuarios` FOREIGN KEY (`CedulaUsuario`) REFERENCES `usuarios` (`CedulaUsuarios`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla entradaunivalle.entradassalidas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `entradassalidas` DISABLE KEYS */;
INSERT IGNORE INTO `entradassalidas` (`IDEntradaSalida`, `Fecha`, `HoraEntrada`, `HoraSalida`, `Temperatura`, `CedulaUsuario`, `CedulaPersonal`) VALUES
	(23, '2020-08-27', '20:43:50', '20:44:24', '35', 789, 1000);
/*!40000 ALTER TABLE `entradassalidas` ENABLE KEYS */;

-- Volcando estructura para tabla entradaunivalle.novedades
CREATE TABLE IF NOT EXISTS `novedades` (
  `IDNovedad` int(11) NOT NULL AUTO_INCREMENT,
  `Temperatura` int(11) DEFAULT NULL,
  `Enfermedades` varchar(50) DEFAULT NULL,
  `ConviveME` varchar(50) DEFAULT NULL,
  `UltimoSitio` varchar(50) DEFAULT NULL,
  `CedulaUsuario` int(11) DEFAULT NULL,
  `CedulaPersonal` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDNovedad`),
  KEY `FK__usuarios` (`CedulaUsuario`),
  KEY `FK__personal` (`CedulaPersonal`),
  CONSTRAINT `FK__personal` FOREIGN KEY (`CedulaPersonal`) REFERENCES `personal` (`CedulaPersonal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__usuarios` FOREIGN KEY (`CedulaUsuario`) REFERENCES `usuarios` (`CedulaUsuarios`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla entradaunivalle.novedades: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `novedades` DISABLE KEYS */;
INSERT IGNORE INTO `novedades` (`IDNovedad`, `Temperatura`, `Enfermedades`, `ConviveME`, `UltimoSitio`, `CedulaUsuario`, `CedulaPersonal`) VALUES
	(2, 38, 'Gripa,Mareo', 'SI', 'Univalle', 456, 1000);
/*!40000 ALTER TABLE `novedades` ENABLE KEYS */;

-- Volcando estructura para tabla entradaunivalle.personal
CREATE TABLE IF NOT EXISTS `personal` (
  `CedulaPersonal` int(11) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(50) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CedulaPersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla entradaunivalle.personal: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT IGNORE INTO `personal` (`CedulaPersonal`, `Username`, `Nombre`, `Apellido`, `Contraseña`, `Correo`, `Telefono`) VALUES
	(1000, 'AndresV', 'Andres', 'Velasquez', '123', 'andres@gmail.com', '3166979911'),
	(2000, 'Peludo', 'Jhon', 'Jairo', '456', 'jhonjairo@gmail.com', '879456123');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;

-- Volcando estructura para tabla entradaunivalle.programas
CREATE TABLE IF NOT EXISTS `programas` (
  `IDPrograma` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDPrograma`)
) ENGINE=InnoDB AUTO_INCREMENT=3752 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla entradaunivalle.programas: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `programas` DISABLE KEYS */;
INSERT IGNORE INTO `programas` (`IDPrograma`, `Nombre`) VALUES
	(2710, 'Tec Electronica'),
	(2711, 'Tec Sitemas'),
	(3251, 'Lic Historia'),
	(3461, 'Psicologia'),
	(3552, 'Musica'),
	(3751, 'Ing Industrial');
/*!40000 ALTER TABLE `programas` ENABLE KEYS */;

-- Volcando estructura para tabla entradaunivalle.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `CedulaUsuarios` int(11) NOT NULL,
  `TipoDocumento` varchar(50) NOT NULL DEFAULT '',
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Ciudad` varchar(50) DEFAULT NULL,
  `Cargo` varchar(50) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Carnet` varchar(50) DEFAULT NULL,
  `Eliminado` varchar(50) DEFAULT 'NO',
  `IDPrograma` int(11) DEFAULT NULL,
  PRIMARY KEY (`CedulaUsuarios`),
  KEY `FK_usuarios_programas` (`IDPrograma`),
  CONSTRAINT `FK_usuarios_programas` FOREIGN KEY (`IDPrograma`) REFERENCES `programas` (`IDPrograma`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla entradaunivalle.usuarios: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT IGNORE INTO `usuarios` (`CedulaUsuarios`, `TipoDocumento`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Ciudad`, `Cargo`, `Correo`, `Carnet`, `Eliminado`, `IDPrograma`) VALUES
	(123, 'C.C', 'Juan', 'Perez', '3125688102', 'Clle 5 # 6-70', 'Tulua', 'Estudiante', 'juan@gmail.com', '1688951', 'SI', 2711),
	(456, 'T.I', 'Carlos', 'Rodriguez', '3185806210', 'Cra 21 # 21-21', 'Buga', 'Estudiante', 'carlos@gmail.com', '1853185', 'SI', 3251),
	(789, 'C.C Extranjera', 'Jhon', 'Valencia', '3697412359', 'Clle 5 # 6-45', 'Buga', 'Docente', 'jhon@gmail.com', '1256568', 'NO', 2710),
	(1234, 'C.C', 'Andres', 'Velasquez', '3166975615', 'Cra 11 # 14sur - 37', 'Buga', 'Estudiante', 'andres@gmail.com', '1855712', 'NO', 2711);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
