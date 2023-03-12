/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/7/2022 1:00:26 PM                         */
/*==============================================================*/


drop table if exists AUDITORIA;

drop table if exists CLIENTE;

drop table if exists DEPARTAMENTO;

drop table if exists EMPLEADO;

drop table if exists EMPLEADO2;

drop table if exists ENCARGADO;

drop table if exists ESTADO;

drop table if exists FAMILIAR;

drop table if exists PARTICIPAR;

drop table if exists PRODUCTOS;

drop table if exists PROYECTO;

drop table if exists SERVICIOS;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: AUDITORIA                                             */
/*==============================================================*/
create table AUDITORIA
(
   IDAUDITORIA          int not null,
   NOMBREUSUARIO        varchar(15) not null,
   FECHAMODIF           datetime,
   TIPO                 varchar(15),
   DESCMODIF            varchar(100),
   primary key (IDAUDITORIA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CI                   int not null,
   NOMBRESERV           varchar(15),
   APELLIDO             varchar(15),
   CORREO               varchar(30),
   TELEFONO             int,
   PAIS                 varchar(20),
   primary key (CI)
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO
(
   NUMDEPTO             int not null,
   CURP3                int,
   NOMBREDEPTO          varchar(20),
   primary key (NUMDEPTO)
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO
(
   CURP                 int not null,
   NUMDEPTO             int not null,
   IDPARTICIPAR         int,
   EMP_CURP             int,
   NOMBRESERV           varchar(15),
   APELLIDOPATERNO      varchar(20),
   APELLIDOMATERNO      varchar(20),
   GENERO               varchar(15),
   NACIMIENTO           date,
   SALARIO              float,
   DIRECCALLE           varchar(30),
   DIRECNUMEXT          varchar(15),
   DIRECCP              varchar(15),
   DIRECESTADO          varchar(15),
   primary key (CURP)
);

/*==============================================================*/
/* Table: EMPLEADO2                                             */
/*==============================================================*/
create table EMPLEADO2
(
   CURP2                int not null,
   NOMBREUSUARIO        varchar(15),
   NOMBRESERV           varchar(15),
   APELLIDOPATERNO      varchar(20),
   APELLIDOMATERNO      varchar(20),
   GENERO               varchar(15),
   NACIMIENTO           date,
   SALARIO              float,
   DIRECCALLE           varchar(30),
   DIRECNUMEXT          varchar(15),
   DIRECCP              varchar(15),
   DIRECESTADO          varchar(15),
   primary key (CURP2)
);

/*==============================================================*/
/* Table: ENCARGADO                                             */
/*==============================================================*/
create table ENCARGADO
(
   CURP3                int not null,
   NUMDEPTO             int not null,
   NOMBRESERV           varchar(15),
   APELLIDOPATERNO      varchar(20),
   APELLIDOMATERNO      varchar(20),
   GENERO               varchar(15),
   NACIMIENTO           date,
   SALARIO              float,
   DIRECCALLE           varchar(30),
   DIRECNUMEXT          varchar(15),
   DIRECCP              varchar(15),
   DIRECESTADO          varchar(15),
   FECHAASDEP           date,
   primary key (CURP3)
);

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO
(
   IDESTADO             char(1) not null,
   DESCESTADO           varchar(15),
   primary key (IDESTADO)
);

/*==============================================================*/
/* Table: FAMILIAR                                              */
/*==============================================================*/
create table FAMILIAR
(
   CURP                 int not null,
   IDFAMILIAR           int not null,
   FAMNOMBRE            varchar(20),
   FAMAPELLIDOPATERNO   varchar(20),
   FAMAPELLIDOMATERNO   varchar(20),
   FAMNACIMIENTO        date,
   PARENTESCO           varchar(15),
   FAMGENERO            varchar(15),
   FAMEDAD              int,
   primary key (CURP, IDFAMILIAR)
);

/*==============================================================*/
/* Table: PARTICIPAR                                            */
/*==============================================================*/
create table PARTICIPAR
(
   IDPARTICIPAR         int not null,
   CURP                 int not null,
   HORAS                time,
   primary key (IDPARTICIPAR)
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS
(
   IDPRODUCTOS          int not null,
   CI                   int,
   DESCRIPCONPROD       varchar(100),
   PRECIOPROD           float,
   NOMBREPROD           varchar(30),
   primary key (IDPRODUCTOS)
);

/*==============================================================*/
/* Table: PROYECTO                                              */
/*==============================================================*/
create table PROYECTO
(
   NUMPROY              int not null,
   NUMDEPTO             int not null,
   IDPARTICIPAR         int,
   CI                   int not null,
   NOMBREPROY           varchar(30),
   ESTADOPROY           varchar(20),
   DESCRIPCIONPROY      varchar(100),
   primary key (NUMPROY)
);

/*==============================================================*/
/* Table: SERVICIOS                                             */
/*==============================================================*/
create table SERVICIOS
(
   IDSERVICIOS          int not null,
   CI                   int,
   NOMBRESERV           varchar(15),
   DESCRIPCIONSERV      varchar(100),
   PRECIOSERV           float,
   primary key (IDSERVICIOS)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   NOMBREUSUARIO        varchar(15) not null,
   CURP2                int not null,
   IDESTADO             char(1) not null,
   PASSWORD             varchar(15),
   FECHACREA            date,
   FECHAMODI            date,
   primary key (NOMBREUSUARIO)
);

alter table AUDITORIA add constraint FK_RELATIONSHIP_13 foreign key (NOMBREUSUARIO)
      references USUARIO (NOMBREUSUARIO) on delete restrict on update restrict;

alter table DEPARTAMENTO add constraint FK_RELATIONSHIP_18 foreign key (CURP3)
      references ENCARGADO (CURP3) on delete restrict on update restrict;

alter table EMPLEADO add constraint FK_ASIGNAR foreign key (NUMDEPTO)
      references DEPARTAMENTO (NUMDEPTO) on delete restrict on update restrict;

alter table EMPLEADO add constraint FK_RELATIONSHIP_8 foreign key (IDPARTICIPAR)
      references PARTICIPAR (IDPARTICIPAR) on delete restrict on update restrict;

alter table EMPLEADO add constraint FK_RELATIONSHIP_9 foreign key (EMP_CURP)
      references EMPLEADO (CURP) on delete restrict on update restrict;

alter table EMPLEADO2 add constraint FK_RELATIONSHIP_10 foreign key (NOMBREUSUARIO)
      references USUARIO (NOMBREUSUARIO) on delete restrict on update restrict;

alter table ENCARGADO add constraint FK_RELATIONSHIP_16 foreign key (NUMDEPTO)
      references DEPARTAMENTO (NUMDEPTO) on delete restrict on update restrict;

alter table FAMILIAR add constraint FK_TENER foreign key (CURP)
      references EMPLEADO (CURP) on delete restrict on update restrict;

alter table PARTICIPAR add constraint FK_RELATIONSHIP_17 foreign key (CURP)
      references EMPLEADO (CURP) on delete restrict on update restrict;

alter table PRODUCTOS add constraint FK_RELATIONSHIP_14 foreign key (CI)
      references CLIENTE (CI) on delete restrict on update restrict;

alter table PROYECTO add constraint FK_CONTROLAR foreign key (NUMDEPTO)
      references DEPARTAMENTO (NUMDEPTO) on delete restrict on update restrict;

alter table PROYECTO add constraint FK_PARTICIPAN foreign key (IDPARTICIPAR)
      references PARTICIPAR (IDPARTICIPAR) on delete restrict on update restrict;

alter table PROYECTO add constraint FK_SOLICITAR foreign key (CI)
      references CLIENTE (CI) on delete restrict on update restrict;

alter table SERVICIOS add constraint FK_RELATIONSHIP_15 foreign key (CI)
      references CLIENTE (CI) on delete restrict on update restrict;

alter table USUARIO add constraint FK_RELATIONSHIP_11 foreign key (IDESTADO)
      references ESTADO (IDESTADO) on delete restrict on update restrict;

alter table USUARIO add constraint FK_RELATIONSHIP_12 foreign key (CURP2)
      references EMPLEADO2 (CURP2) on delete restrict on update restrict;

