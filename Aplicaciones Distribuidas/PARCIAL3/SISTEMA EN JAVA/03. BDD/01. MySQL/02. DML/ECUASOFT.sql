INSERT INTO XEEST_ESTAD (`XEEST_CODIGO`, `XEEST_DESCRI`) VALUES
('1', 'Activo'),
('2', 'Nuevo');

INSERT INTO XEPER_PERFI (`XEPER_CODIGO`, `XEPER_DESCRI`, `XEPER_OBSER`) VALUES
('A', 'Administrador', 'Ninguna'),
('C', 'Cliente', 'Ninguna'),
('E', 'Empleado', 'Ninguna'),
('N', 'Ninguno', 'Sin Perfil');

INSERT INTO TETPR_TIPPRO (TETPR_CODIGO, TETPR_DESCRI) VALUES
('D', 'Desarrollo'),
('A', 'Adquisición');

INSERT INTO TECEM_CAREMP (TECEM_CODIGO, TECEM_DESCRI) VALUES
('A','Analista'),
('D','Desarrollador'),
('J','Jefe de Proyecto'),
('N','Administrador'),
('S', 'Sin Cargo');

INSERT INTO PEEMP_EMPLE (PEEMP_CODIGO, TECEM_CODIGO, PEEMP_APELLI, PEEMP_NOMBRE, PEEMP_FECNAC, PEEMP_FECSAL, PEEMP_DIREC, PEEMP_TELEF, PEEMP_EMAIL, PEEMP_CEDULA, PEEMP_FOTO, PEEMP_CARFAM, PEEMP_PASAPO, DISCAPA)
VALUES ('1', 'N','Chuquimarca', 'Kevin', '1999-02-01', '2023-02-06', 'Tumbaco', '0984991746', 'santi.kevin0936@gmail.com', '1727195420', '1', '3', '-', 0);

INSERT INTO XEUSU_USUAR (`XEUSU_PASWD`, `XEEST_CODIGO`, `PEEMP_CODIGO`, `XEUSU_FECCRE`, `XEUSU_FECMOD`, `XEUSU_PIEFIR`) VALUES
('7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', '2', '1', '2023-02-09 00:00:00', '2023-02-09 00:00:00', 'firma');

INSERT INTO XEUXP_USUPE (`XEUSU_PASWD`, `XEPER_CODIGO`, `XEUXP_FECASI`, `XEUXP_FECRET`) VALUES
('7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', 'A', '2023-02-05', '2023-02-05');