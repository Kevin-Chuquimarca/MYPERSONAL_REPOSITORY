/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/5/2023 2:56:02 PM                          */
/*==============================================================*/


drop table if exists PEEMP_EMPLE;

drop table if exists TECEM_CAREMP;

drop table if exists TEPRO_PROYEC;

drop table if exists TETPR_TIPPRO;

drop table if exists XEEST_ESTAD;

drop table if exists XEOPC_OPCIO;

drop table if exists XEOXP_OPCPE;

drop table if exists XEPER_PERFI;

drop table if exists XESIS_SISTE;

drop table if exists XEUSU_USUAR;

drop table if exists XEUXP_USUPE;

/*==============================================================*/
/* Table: PEEMP_EMPLE                                           */
/*==============================================================*/
create table PEEMP_EMPLE
(
   PEEMP_CODIGO         char(6) not null,
   TECEM_CODIGO         char(1) not null,
   TEPRO_CODIGO         int,
   PEEMP_APELLI         varchar(50) not null,
   PEEMP_NOMBRE         varchar(50) not null,
   PEEMP_FECNAC         date not null,
   PEEMP_FECSAL         date not null,
   PEEMP_DIREC          varchar(200) not null,
   PEEMP_TELEF          varchar(15) not null,
   PEEMP_EMAIL          varchar(100) not null,
   PEEMP_CEDULA         varchar(10) not null,
   PEEMP_FOTO           varchar(100),
   PEEMP_CARFAM         numeric(3,0) not null,
   PEEMP_PASAPO         varchar(15) not null,
   DISCAPA              blob not null,
   primary key (PEEMP_CODIGO)
);

alter table PEEMP_EMPLE comment 'Entidad para realizar la gestion de empleados';

/*==============================================================*/
/* Table: TECEM_CAREMP                                          */
/*==============================================================*/
create table TECEM_CAREMP
(
   TECEM_CODIGO         char(1) not null,
   TECEM_DESCRI         varchar(20),
   primary key (TECEM_CODIGO)
);

/*==============================================================*/
/* Table: TEPRO_PROYEC                                          */
/*==============================================================*/
create table TEPRO_PROYEC
(
   TEPRO_CODIGO         int not null auto_increment,
   TETPR_CODIGO         char(1) not null,
   TEPRO_NOMBR          varchar(50),
   TEPRO_FECHAI         date,
   TEPRO_FECHAF         date,
   TETPR_DESCRI         varchar(150),
   TEPRO_COSTO          float,
   primary key (TEPRO_CODIGO)
);

/*==============================================================*/
/* Table: TETPR_TIPPRO                                          */
/*==============================================================*/
create table TETPR_TIPPRO
(
   TETPR_CODIGO         char(1) not null,
   TETPR_DESCRI         varchar(150),
   primary key (TETPR_CODIGO)
);

/*==============================================================*/
/* Table: XEEST_ESTAD                                           */
/*==============================================================*/
create table XEEST_ESTAD
(
   XEEST_CODIGO         char(1) not null,
   XEEST_DESCRI         varchar(50) not null,
   primary key (XEEST_CODIGO)
);

alter table XEEST_ESTAD comment 'Entidad utilizada para gestionar el estado de las difetrente';

/*==============================================================*/
/* Table: XEOPC_OPCIO                                           */
/*==============================================================*/
create table XEOPC_OPCIO
(
   XEOPC_CODIGO         char(3) not null,
   XESIS_CODIGO         char(1) not null,
   XEOPC_DESCRI         varchar(100) not null,
   primary key (XEOPC_CODIGO)
);

alter table XEOPC_OPCIO comment 'Entidad utilizada para realizar el registro de las diferente';

/*==============================================================*/
/* Table: XEOXP_OPCPE                                           */
/*==============================================================*/
create table XEOXP_OPCPE
(
   XEOPC_CODIGO         char(3) not null,
   XEPER_CODIGO         char(8) not null,
   XEOXP_FECASI         date not null,
   XEOXP_FECRET         date,
   primary key (XEOPC_CODIGO, XEPER_CODIGO, XEOXP_FECASI)
);

alter table XEOXP_OPCPE comment 'Entidad utilizada para llevar el registro de las opciones qu';

/*==============================================================*/
/* Table: XEPER_PERFI                                           */
/*==============================================================*/
create table XEPER_PERFI
(
   XEPER_CODIGO         char(8) not null,
   XEPER_DESCRI         varchar(100) not null,
   XEPER_OBSER          text,
   primary key (XEPER_CODIGO)
);

alter table XEPER_PERFI comment 'Entidad utilizada para realizar la gestión de los diferentes';

/*==============================================================*/
/* Table: XESIS_SISTE                                           */
/*==============================================================*/
create table XESIS_SISTE
(
   XESIS_CODIGO         char(1) not null,
   XESIS_DESCRI         varchar(50) not null,
   primary key (XESIS_CODIGO)
);

alter table XESIS_SISTE comment 'Entidad utilizada para realziar la gestión de los diferentes';

/*==============================================================*/
/* Table: XEUSU_USUAR                                           */
/*==============================================================*/
create table XEUSU_USUAR
(
   XEUSU_PASWD          varchar(40) not null,
   XEEST_CODIGO         char(1) not null,
   PEEMP_CODIGO         char(6) not null,
   XEUSU_FECCRE         datetime not null,
   XEUSU_FECMOD         datetime not null,
   XEUSU_PIEFIR         varchar(100) not null,
   primary key (XEUSU_PASWD)
);

alter table XEUSU_USUAR comment 'Entidad relacionada para gentionar los usuario que ingrsan a';

/*==============================================================*/
/* Table: XEUXP_USUPE                                           */
/*==============================================================*/
create table XEUXP_USUPE
(
   XEUSU_PASWD          varchar(40) not null,
   XEPER_CODIGO         char(8) not null,
   XEUXP_FECASI         date not null,
   XEUXP_FECRET         date,
   primary key (XEUSU_PASWD, XEPER_CODIGO, XEUXP_FECASI)
);

alter table XEUXP_USUPE comment 'Entidad utilizada para realizar el registro de los diferente';

alter table PEEMP_EMPLE add constraint FK_TEPLE_TECEM foreign key (TECEM_CODIGO)
      references TECEM_CAREMP (TECEM_CODIGO);

alter table PEEMP_EMPLE add constraint FK_TEPLE_TEPRO foreign key (TEPRO_CODIGO)
      references TEPRO_PROYEC (TEPRO_CODIGO);

alter table TEPRO_PROYEC add constraint FK_TEPRO_TETPR foreign key (TETPR_CODIGO)
      references TETPR_TIPPRO (TETPR_CODIGO);

alter table XEOPC_OPCIO add constraint FK_XR_XESIS_XEOPC foreign key (XESIS_CODIGO)
      references XESIS_SISTE (XESIS_CODIGO);

alter table XEOXP_OPCPE add constraint FK_XR_XEOPC_XEOXP foreign key (XEOPC_CODIGO)
      references XEOPC_OPCIO (XEOPC_CODIGO);

alter table XEOXP_OPCPE add constraint FK_XR_XEPER_XEOXP foreign key (XEPER_CODIGO)
      references XEPER_PERFI (XEPER_CODIGO);

alter table XEUSU_USUAR add constraint FK_XR_PEEMP_XEUSU foreign key (PEEMP_CODIGO)
      references PEEMP_EMPLE (PEEMP_CODIGO);

alter table XEUSU_USUAR add constraint FK_XR_XEEST_XEUSU foreign key (XEEST_CODIGO)
      references XEEST_ESTAD (XEEST_CODIGO);

alter table XEUXP_USUPE add constraint FK_XR_XEPER_XEUXP foreign key (XEPER_CODIGO)
      references XEPER_PERFI (XEPER_CODIGO);

alter table XEUXP_USUPE add constraint FK_XR_XEUSU_XEUXP foreign key (XEUSU_PASWD)
      references XEUSU_USUAR (XEUSU_PASWD);

