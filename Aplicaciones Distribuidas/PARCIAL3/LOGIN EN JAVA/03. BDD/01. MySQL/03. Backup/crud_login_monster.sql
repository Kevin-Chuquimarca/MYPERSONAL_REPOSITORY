-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2023 at 06:51 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crud_login_monster`
--

-- --------------------------------------------------------

--
-- Table structure for table `peemp_emple`
--

CREATE TABLE `peemp_emple` (
  `PEEMP_CODIGO` char(6) NOT NULL,
  `PEEMP_APELLI` varchar(50) NOT NULL,
  `PEEMP_NOMBRE` varchar(50) NOT NULL,
  `PEEMP_FECNAC` date NOT NULL,
  `PEEMP_FECSAL` date NOT NULL,
  `PEEMP_DIREC` varchar(200) NOT NULL,
  `PEEMP_TELEF` varchar(15) NOT NULL,
  `PEEMP_EMAIL` varchar(100) NOT NULL,
  `PEEMP_CEDULA` varchar(10) NOT NULL,
  `PEEMP_FOTO` varchar(100) DEFAULT NULL,
  `PEEMP_CARFAM` decimal(3,0) NOT NULL,
  `PEEMP_PASAPO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad para realizar la gestion de empleados';

--
-- Dumping data for table `peemp_emple`
--

INSERT INTO `peemp_emple` (`PEEMP_CODIGO`, `PEEMP_APELLI`, `PEEMP_NOMBRE`, `PEEMP_FECNAC`, `PEEMP_FECSAL`, `PEEMP_DIREC`, `PEEMP_TELEF`, `PEEMP_EMAIL`, `PEEMP_CEDULA`, `PEEMP_FOTO`, `PEEMP_CARFAM`, `PEEMP_PASAPO`) VALUES
('1', 'Chuquimarca', 'Kevin', '1999-02-01', '2023-02-06', 'Tumbaco', '0984991746', 'santi.kevin0936@gmail.com', '1727195420', '1', '3', '-'),
('2', 'Chuquimarca', 'Kevin', '2023-03-05', '2023-03-05', 'Tumbaco', '0984991746', 'kschuquimarca@espe.edu.ec', '1727195420', '2', '0', '-'),
('4', 'Llulluna', 'Santiago', '2022-02-01', '2023-02-14', 'Quito', '0984991746', 'santi.kevin0984@gmail.com', '1727195420', '4', '0', '-'),
('5', 'Monster', 'Mater', '1966-02-10', '2023-02-15', 'Capelo', '09844991746', 'michaelcoba63@gmail.com', '1727195420', '5', '4', '-'),
('6', 'Chuquimarca', 'Kevin', '2023-03-05', '2023-03-05', 'Tumbaco', '0984991746', 'kschuquimarca@espe.edu.ec', '1727195420', '6', '0', '-'),
('8', 'Chuquimarca', 'Kevin', '2023-03-05', '2023-03-05', 'Tumbaco', '0984991746', 'kschuquimarca@espe.edu.ec', '1727195420', '8', '0', '-');

-- --------------------------------------------------------

--
-- Table structure for table `xeest_estad`
--

CREATE TABLE `xeest_estad` (
  `XEEST_CODIGO` char(1) NOT NULL,
  `XEEST_DESCRI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para gestionar el estado de las difetrente';

--
-- Dumping data for table `xeest_estad`
--

INSERT INTO `xeest_estad` (`XEEST_CODIGO`, `XEEST_DESCRI`) VALUES
('1', 'Activo'),
('2', 'Nuevo');

-- --------------------------------------------------------

--
-- Table structure for table `xeopc_opcio`
--

CREATE TABLE `xeopc_opcio` (
  `XEOPC_CODIGO` char(3) NOT NULL,
  `XESIS_CODIGO` char(1) NOT NULL,
  `XEOPC_DESCRI` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para realizar el registro de las diferente';

-- --------------------------------------------------------

--
-- Table structure for table `xeoxp_opcpe`
--

CREATE TABLE `xeoxp_opcpe` (
  `XEOPC_CODIGO` char(3) NOT NULL,
  `XEPER_CODIGO` char(8) NOT NULL,
  `XEOXP_FECASI` date NOT NULL,
  `XEOXP_FECRET` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para llevar el registro de las opciones qu';

-- --------------------------------------------------------

--
-- Table structure for table `xeper_perfi`
--

CREATE TABLE `xeper_perfi` (
  `XEPER_CODIGO` char(8) NOT NULL,
  `XEPER_DESCRI` varchar(100) NOT NULL,
  `XEPER_OBSER` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para realizar la gestiï¿½n de los diferentes';

--
-- Dumping data for table `xeper_perfi`
--

INSERT INTO `xeper_perfi` (`XEPER_CODIGO`, `XEPER_DESCRI`, `XEPER_OBSER`) VALUES
('A', 'Administrador', 'Ninguna'),
('C', 'Cliente', 'Ninguna'),
('E', 'Empleado', 'Ninguna'),
('N', 'Ninguno', 'Sin Perfil');

-- --------------------------------------------------------

--
-- Table structure for table `xesis_siste`
--

CREATE TABLE `xesis_siste` (
  `XESIS_CODIGO` char(1) NOT NULL,
  `XESIS_DESCRI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para realziar la gestiï¿½n de los diferentes';

-- --------------------------------------------------------

--
-- Table structure for table `xeusu_usuar`
--

CREATE TABLE `xeusu_usuar` (
  `XEUSU_PASWD` varchar(40) NOT NULL,
  `XEEST_CODIGO` char(1) NOT NULL,
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEUSU_FECCRE` datetime NOT NULL,
  `XEUSU_FECMOD` datetime NOT NULL,
  `XEUSU_PIEFIR` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad relacionada para gentionar los usuario que ingrsan a';

--
-- Dumping data for table `xeusu_usuar`
--

INSERT INTO `xeusu_usuar` (`XEUSU_PASWD`, `XEEST_CODIGO`, `PEEMP_CODIGO`, `XEUSU_FECCRE`, `XEUSU_FECMOD`, `XEUSU_PIEFIR`) VALUES
('3836D8094BDAE3C1D997A8D2CEBB5EFACB5D36D4', '1', '8', '2023-03-05 12:11:38', '2023-03-05 12:11:38', 'firma'),
('7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', '2', '1', '2023-02-09 00:00:00', '2023-02-09 00:00:00', 'firma'),
('7FBDEF59759A0BDF16A9F8EF82A49729737D4D5F', '2', '4', '2023-02-14 23:33:04', '2023-02-14 23:33:04', 'firma'),
('8CB2237D0679CA88DB6464EAC60DA96345513964', '2', '5', '2023-02-15 14:47:13', '2023-02-15 14:48:04', 'firma'),
('D08052863A19F021A5078E11AE7E535C0B76DCA6', '1', '6', '2023-03-05 12:07:51', '2023-03-05 12:07:51', 'firma'),
('DC146B6E14AE3DBB606428DD279DD15EF31E3E66', '2', '2', '2023-03-05 11:04:57', '2023-03-05 11:06:26', 'firma');

-- --------------------------------------------------------

--
-- Table structure for table `xeuxp_usupe`
--

CREATE TABLE `xeuxp_usupe` (
  `XEUSU_PASWD` varchar(40) NOT NULL,
  `XEPER_CODIGO` char(8) NOT NULL,
  `XEUXP_FECASI` date NOT NULL,
  `XEUXP_FECRET` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Entidad utilizada para realizar el registro de los diferente';

--
-- Dumping data for table `xeuxp_usupe`
--

INSERT INTO `xeuxp_usupe` (`XEUSU_PASWD`, `XEPER_CODIGO`, `XEUXP_FECASI`, `XEUXP_FECRET`) VALUES
('3836D8094BDAE3C1D997A8D2CEBB5EFACB5D36D4', 'N', '2023-03-05', '2023-03-05'),
('7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', 'A', '2023-02-05', '2023-02-05'),
('7FBDEF59759A0BDF16A9F8EF82A49729737D4D5F', 'N', '2023-02-15', '2023-02-14'),
('8CB2237D0679CA88DB6464EAC60DA96345513964', 'N', '2023-02-15', '2023-02-15'),
('D08052863A19F021A5078E11AE7E535C0B76DCA6', 'N', '2023-03-05', '2023-03-05'),
('DC146B6E14AE3DBB606428DD279DD15EF31E3E66', 'N', '2023-03-05', '2023-03-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `peemp_emple`
--
ALTER TABLE `peemp_emple`
  ADD PRIMARY KEY (`PEEMP_CODIGO`);

--
-- Indexes for table `xeest_estad`
--
ALTER TABLE `xeest_estad`
  ADD PRIMARY KEY (`XEEST_CODIGO`);

--
-- Indexes for table `xeopc_opcio`
--
ALTER TABLE `xeopc_opcio`
  ADD PRIMARY KEY (`XEOPC_CODIGO`),
  ADD KEY `FK_XR_XESIS_XEOPC` (`XESIS_CODIGO`);

--
-- Indexes for table `xeoxp_opcpe`
--
ALTER TABLE `xeoxp_opcpe`
  ADD PRIMARY KEY (`XEOPC_CODIGO`,`XEPER_CODIGO`,`XEOXP_FECASI`),
  ADD KEY `FK_XR_XEPER_XEOXP` (`XEPER_CODIGO`);

--
-- Indexes for table `xeper_perfi`
--
ALTER TABLE `xeper_perfi`
  ADD PRIMARY KEY (`XEPER_CODIGO`);

--
-- Indexes for table `xesis_siste`
--
ALTER TABLE `xesis_siste`
  ADD PRIMARY KEY (`XESIS_CODIGO`);

--
-- Indexes for table `xeusu_usuar`
--
ALTER TABLE `xeusu_usuar`
  ADD PRIMARY KEY (`XEUSU_PASWD`),
  ADD KEY `FK_XR_PEEMP_XEUSU` (`PEEMP_CODIGO`),
  ADD KEY `FK_XR_XEEST_XEUSU` (`XEEST_CODIGO`);

--
-- Indexes for table `xeuxp_usupe`
--
ALTER TABLE `xeuxp_usupe`
  ADD PRIMARY KEY (`XEUSU_PASWD`,`XEPER_CODIGO`,`XEUXP_FECASI`),
  ADD KEY `FK_XR_XEPER_XEUXP` (`XEPER_CODIGO`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `xeopc_opcio`
--
ALTER TABLE `xeopc_opcio`
  ADD CONSTRAINT `FK_XR_XESIS_XEOPC` FOREIGN KEY (`XESIS_CODIGO`) REFERENCES `xesis_siste` (`XESIS_CODIGO`);

--
-- Constraints for table `xeoxp_opcpe`
--
ALTER TABLE `xeoxp_opcpe`
  ADD CONSTRAINT `FK_XR_XEOPC_XEOXP` FOREIGN KEY (`XEOPC_CODIGO`) REFERENCES `xeopc_opcio` (`XEOPC_CODIGO`),
  ADD CONSTRAINT `FK_XR_XEPER_XEOXP` FOREIGN KEY (`XEPER_CODIGO`) REFERENCES `xeper_perfi` (`XEPER_CODIGO`);

--
-- Constraints for table `xeusu_usuar`
--
ALTER TABLE `xeusu_usuar`
  ADD CONSTRAINT `FK_XR_PEEMP_XEUSU` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `peemp_emple` (`PEEMP_CODIGO`),
  ADD CONSTRAINT `FK_XR_XEEST_XEUSU` FOREIGN KEY (`XEEST_CODIGO`) REFERENCES `xeest_estad` (`XEEST_CODIGO`);

--
-- Constraints for table `xeuxp_usupe`
--
ALTER TABLE `xeuxp_usupe`
  ADD CONSTRAINT `FK_XR_XEPER_XEUXP` FOREIGN KEY (`XEPER_CODIGO`) REFERENCES `xeper_perfi` (`XEPER_CODIGO`),
  ADD CONSTRAINT `FK_XR_XEUSU_XEUXP` FOREIGN KEY (`XEUSU_PASWD`) REFERENCES `xeusu_usuar` (`XEUSU_PASWD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
