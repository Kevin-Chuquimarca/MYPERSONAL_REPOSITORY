/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2014                    */
/* Created on:     3/4/2023 12:42:26 PM                         */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEEMP_EMPLE') and o.name = 'FK_PEEMP_EM_TEPLE_TEC_TECEM_CA')
alter table PEEMP_EMPLE
   drop constraint FK_PEEMP_EM_TEPLE_TEC_TECEM_CA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEEMP_EMPLE') and o.name = 'FK_PEEMP_EM_TEPLE_TEP_TEPRO_PR')
alter table PEEMP_EMPLE
   drop constraint FK_PEEMP_EM_TEPLE_TEP_TEPRO_PR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TEPRO_PROYEC') and o.name = 'FK_TEPRO_PR_TEPRO_TET_TETPR_TI')
alter table TEPRO_PROYEC
   drop constraint FK_TEPRO_PR_TEPRO_TET_TETPR_TI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEOPC_OPCIO') and o.name = 'FK_XEOPC_OP_XR_XESIS__XESIS_SI')
alter table XEOPC_OPCIO
   drop constraint FK_XEOPC_OP_XR_XESIS__XESIS_SI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEOXP_OPCPE') and o.name = 'FK_XEOXP_OP_XR_XEOPC__XEOPC_OP')
alter table XEOXP_OPCPE
   drop constraint FK_XEOXP_OP_XR_XEOPC__XEOPC_OP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEOXP_OPCPE') and o.name = 'FK_XEOXP_OP_XR_XEPER__XEPER_PE')
alter table XEOXP_OPCPE
   drop constraint FK_XEOXP_OP_XR_XEPER__XEPER_PE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEUSU_USUAR') and o.name = 'FK_XEUSU_US_XR_PEEMP__PEEMP_EM')
alter table XEUSU_USUAR
   drop constraint FK_XEUSU_US_XR_PEEMP__PEEMP_EM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEUSU_USUAR') and o.name = 'FK_XEUSU_US_XR_XEEST__XEEST_ES')
alter table XEUSU_USUAR
   drop constraint FK_XEUSU_US_XR_XEEST__XEEST_ES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEUXP_USUPE') and o.name = 'FK_XEUXP_US_XR_XEPER__XEPER_PE')
alter table XEUXP_USUPE
   drop constraint FK_XEUXP_US_XR_XEPER__XEPER_PE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('XEUXP_USUPE') and o.name = 'FK_XEUXP_US_XR_XEUSU__XEUSU_US')
alter table XEUXP_USUPE
   drop constraint FK_XEUXP_US_XR_XEUSU__XEUSU_US
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEEMP_EMPLE')
            and   name  = 'TEPLE_TEPRO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEEMP_EMPLE.TEPLE_TEPRO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEEMP_EMPLE')
            and   name  = 'TEPLE_TECEM_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEEMP_EMPLE.TEPLE_TECEM_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PEEMP_EMPLE')
            and   type = 'U')
   drop table PEEMP_EMPLE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TECEM_CAREMP')
            and   type = 'U')
   drop table TECEM_CAREMP
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TEPRO_PROYEC')
            and   name  = 'TEPRO_TETPR_FK'
            and   indid > 0
            and   indid < 255)
   drop index TEPRO_PROYEC.TEPRO_TETPR_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TEPRO_PROYEC')
            and   type = 'U')
   drop table TEPRO_PROYEC
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TETPR_TIPPRO')
            and   type = 'U')
   drop table TETPR_TIPPRO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEEST_ESTAD')
            and   type = 'U')
   drop table XEEST_ESTAD
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEOPC_OPCIO')
            and   name  = 'XR_XESIS_XEOPC_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEOPC_OPCIO.XR_XESIS_XEOPC_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEOPC_OPCIO')
            and   type = 'U')
   drop table XEOPC_OPCIO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEOXP_OPCPE')
            and   name  = 'XR_XEOPC_XEOXP_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEOXP_OPCPE.XR_XEOPC_XEOXP_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEOXP_OPCPE')
            and   name  = 'XR_XEPER_XEOXP_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEOXP_OPCPE.XR_XEPER_XEOXP_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEOXP_OPCPE')
            and   type = 'U')
   drop table XEOXP_OPCPE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEPER_PERFI')
            and   type = 'U')
   drop table XEPER_PERFI
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XESIS_SISTE')
            and   type = 'U')
   drop table XESIS_SISTE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEUSU_USUAR')
            and   name  = 'XR_PEEMP_XEUSU_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEUSU_USUAR.XR_PEEMP_XEUSU_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEUSU_USUAR')
            and   name  = 'XR_XEEST_XEUSU_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEUSU_USUAR.XR_XEEST_XEUSU_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEUSU_USUAR')
            and   type = 'U')
   drop table XEUSU_USUAR
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEUXP_USUPE')
            and   name  = 'XR_XEUSU_XEUXP_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEUXP_USUPE.XR_XEUSU_XEUXP_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('XEUXP_USUPE')
            and   name  = 'XR_XEPER_XEUXP_FK'
            and   indid > 0
            and   indid < 255)
   drop index XEUXP_USUPE.XR_XEPER_XEUXP_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('XEUXP_USUPE')
            and   type = 'U')
   drop table XEUXP_USUPE
go

/*==============================================================*/
/* Table: PEEMP_EMPLE                                           */
/*==============================================================*/
create table PEEMP_EMPLE (
   PEEMP_CODIGO         char(6)              not null,
   TECEM_CODIGO         char(1)              not null,
   TEPRO_CODIGO         int                  null,
   PEEMP_APELLI         varchar(50)          not null,
   PEEMP_NOMBRE         varchar(50)          not null,
   PEEMP_FECNAC         datetime             not null,
   PEEMP_FECSAL         datetime             not null,
   PEEMP_DIREC          varchar(200)         not null,
   PEEMP_TELEF          varchar(15)          not null,
   PEEMP_EMAIL          varchar(100)         not null,
   PEEMP_CEDULA         varchar(10)          not null,
   PEEMP_FOTO           varchar(100)         null,
   PEEMP_CARFAM         numeric(3,0)         not null,
   PEEMP_PASAPO         varchar(15)          not null,
   DISCAPA              binary(1)            not null,
   constraint PK_PEEMP_EMPLE primary key (PEEMP_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PEEMP_EMPLE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PEEMP_EMPLE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad para realizar la gestion de empleados', 
   'user', @CurrentUser, 'table', 'PEEMP_EMPLE'
go

/*==============================================================*/
/* Index: TEPLE_TECEM_FK                                        */
/*==============================================================*/




create nonclustered index TEPLE_TECEM_FK on PEEMP_EMPLE (TECEM_CODIGO ASC)
go

/*==============================================================*/
/* Index: TEPLE_TEPRO_FK                                        */
/*==============================================================*/




create nonclustered index TEPLE_TEPRO_FK on PEEMP_EMPLE (TEPRO_CODIGO ASC)
go

/*==============================================================*/
/* Table: TECEM_CAREMP                                          */
/*==============================================================*/
create table TECEM_CAREMP (
   TECEM_CODIGO         char(1)              not null,
   TECEM_DESCRI         varchar(20)          null,
   constraint PK_TECEM_CAREMP primary key (TECEM_CODIGO)
)
go

/*==============================================================*/
/* Table: TEPRO_PROYEC                                          */
/*==============================================================*/
create table TEPRO_PROYEC (
   TEPRO_CODIGO         int                  not null,
   TETPR_CODIGO         char(1)              not null,
   TEPRO_NOMBR          varchar(50)          null,
   TEPRO_FECHAI         datetime             null,
   TEPRO_FECHAF         datetime             null,
   TETPR_TEPROD         varchar(150)         null,
   TEPRO_COSTO          float                null,
   constraint PK_TEPRO_PROYEC primary key (TEPRO_CODIGO)
)
go

/*==============================================================*/
/* Index: TEPRO_TETPR_FK                                        */
/*==============================================================*/




create nonclustered index TEPRO_TETPR_FK on TEPRO_PROYEC (TETPR_CODIGO ASC)
go

/*==============================================================*/
/* Table: TETPR_TIPPRO                                          */
/*==============================================================*/
create table TETPR_TIPPRO (
   TETPR_CODIGO         char(1)              not null,
   TETPR_TEPROD         varchar(150)         null,
   constraint PK_TETPR_TIPPRO primary key (TETPR_CODIGO)
)
go

/*==============================================================*/
/* Table: XEEST_ESTAD                                           */
/*==============================================================*/
create table XEEST_ESTAD (
   XEEST_CODIGO         char(1)              not null,
   XEEST_DESCRI         varchar(50)          not null,
   constraint PK_XEEST_ESTAD primary key (XEEST_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEEST_ESTAD') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEEST_ESTAD' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para gestionar el estado de las difetrentes tablas', 
   'user', @CurrentUser, 'table', 'XEEST_ESTAD'
go

/*==============================================================*/
/* Table: XEOPC_OPCIO                                           */
/*==============================================================*/
create table XEOPC_OPCIO (
   XEOPC_CODIGO         char(3)              not null,
   XESIS_CODIGO         char(1)              not null,
   XEOPC_DESCRI         varchar(100)         not null,
   constraint PK_XEOPC_OPCIO primary key (XEOPC_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEOPC_OPCIO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEOPC_OPCIO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para realizar el registro de las diferentes opciones de un sistema', 
   'user', @CurrentUser, 'table', 'XEOPC_OPCIO'
go

/*==============================================================*/
/* Index: XR_XESIS_XEOPC_FK                                     */
/*==============================================================*/




create nonclustered index XR_XESIS_XEOPC_FK on XEOPC_OPCIO (XESIS_CODIGO ASC)
go

/*==============================================================*/
/* Table: XEOXP_OPCPE                                           */
/*==============================================================*/
create table XEOXP_OPCPE (
   XEOPC_CODIGO         char(3)              not null,
   XEPER_CODIGO         char(8)              not null,
   XEOXP_FECASI         datetime             not null,
   XEOXP_FECRET         datetime             null,
   constraint PK_XEOXP_OPCPE primary key (XEOPC_CODIGO, XEPER_CODIGO, XEOXP_FECASI)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEOXP_OPCPE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEOXP_OPCPE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para llevar el registro de las opciones que pertenecen a un perfil', 
   'user', @CurrentUser, 'table', 'XEOXP_OPCPE'
go

/*==============================================================*/
/* Index: XR_XEPER_XEOXP_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEPER_XEOXP_FK on XEOXP_OPCPE (XEPER_CODIGO ASC)
go

/*==============================================================*/
/* Index: XR_XEOPC_XEOXP_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEOPC_XEOXP_FK on XEOXP_OPCPE (XEOPC_CODIGO ASC)
go

/*==============================================================*/
/* Table: XEPER_PERFI                                           */
/*==============================================================*/
create table XEPER_PERFI (
   XEPER_CODIGO         char(8)              not null,
   XEPER_DESCRI         varchar(100)         not null,
   XEPER_OBSER          text                 null,
   constraint PK_XEPER_PERFI primary key (XEPER_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEPER_PERFI') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEPER_PERFI' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para realizar la gestión de los diferentes perfiles', 
   'user', @CurrentUser, 'table', 'XEPER_PERFI'
go

/*==============================================================*/
/* Table: XESIS_SISTE                                           */
/*==============================================================*/
create table XESIS_SISTE (
   XESIS_CODIGO         char(1)              not null,
   XESIS_DESCRI         varchar(50)          not null,
   constraint PK_XESIS_SISTE primary key (XESIS_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XESIS_SISTE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XESIS_SISTE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para realziar la gestión de los diferentes subsistemas', 
   'user', @CurrentUser, 'table', 'XESIS_SISTE'
go

/*==============================================================*/
/* Table: XEUSU_USUAR                                           */
/*==============================================================*/
create table XEUSU_USUAR (
   XEUSU_PASWD          varchar(16)          not null,
   XEEST_CODIGO         char(1)              not null,
   PEEMP_CODIGO         char(6)              not null,
   XEUSU_FECCRE         datetime             not null,
   XEUSU_FECMOD         datetime             not null,
   XEUSU_PIEFIR         varchar(100)         not null,
   constraint PK_XEUSU_USUAR primary key (XEUSU_PASWD)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEUSU_USUAR') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEUSU_USUAR' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad relacionada para gentionar los usuario que ingrsan al sistema', 
   'user', @CurrentUser, 'table', 'XEUSU_USUAR'
go

/*==============================================================*/
/* Index: XR_XEEST_XEUSU_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEEST_XEUSU_FK on XEUSU_USUAR (XEEST_CODIGO ASC)
go

/*==============================================================*/
/* Index: XR_PEEMP_XEUSU_FK                                     */
/*==============================================================*/




create nonclustered index XR_PEEMP_XEUSU_FK on XEUSU_USUAR (PEEMP_CODIGO ASC)
go

/*==============================================================*/
/* Table: XEUXP_USUPE                                           */
/*==============================================================*/
create table XEUXP_USUPE (
   XEUSU_PASWD          varchar(16)          not null,
   XEPER_CODIGO         char(8)              not null,
   XEUXP_FECASI         datetime             not null,
   XEUXP_FECRET         datetime             null,
   constraint PK_XEUXP_USUPE primary key (XEUSU_PASWD, XEPER_CODIGO, XEUXP_FECASI)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('XEUXP_USUPE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'XEUXP_USUPE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad utilizada para realizar el registro de los diferentes usuarios que pertenecen a un perfil', 
   'user', @CurrentUser, 'table', 'XEUXP_USUPE'
go

/*==============================================================*/
/* Index: XR_XEPER_XEUXP_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEPER_XEUXP_FK on XEUXP_USUPE (XEPER_CODIGO ASC)
go

/*==============================================================*/
/* Index: XR_XEUSU_XEUXP_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEUSU_XEUXP_FK on XEUXP_USUPE (XEUSU_PASWD ASC)
go

alter table PEEMP_EMPLE
   add constraint FK_PEEMP_EM_TEPLE_TEC_TECEM_CA foreign key (TECEM_CODIGO)
      references TECEM_CAREMP (TECEM_CODIGO)
go

alter table PEEMP_EMPLE
   add constraint FK_PEEMP_EM_TEPLE_TEP_TEPRO_PR foreign key (TEPRO_CODIGO)
      references TEPRO_PROYEC (TEPRO_CODIGO)
go

alter table TEPRO_PROYEC
   add constraint FK_TEPRO_PR_TEPRO_TET_TETPR_TI foreign key (TETPR_CODIGO)
      references TETPR_TIPPRO (TETPR_CODIGO)
go

alter table XEOPC_OPCIO
   add constraint FK_XEOPC_OP_XR_XESIS__XESIS_SI foreign key (XESIS_CODIGO)
      references XESIS_SISTE (XESIS_CODIGO)
go

alter table XEOXP_OPCPE
   add constraint FK_XEOXP_OP_XR_XEOPC__XEOPC_OP foreign key (XEOPC_CODIGO)
      references XEOPC_OPCIO (XEOPC_CODIGO)
go

alter table XEOXP_OPCPE
   add constraint FK_XEOXP_OP_XR_XEPER__XEPER_PE foreign key (XEPER_CODIGO)
      references XEPER_PERFI (XEPER_CODIGO)
go

alter table XEUSU_USUAR
   add constraint FK_XEUSU_US_XR_PEEMP__PEEMP_EM foreign key (PEEMP_CODIGO)
      references PEEMP_EMPLE (PEEMP_CODIGO)
go

alter table XEUSU_USUAR
   add constraint FK_XEUSU_US_XR_XEEST__XEEST_ES foreign key (XEEST_CODIGO)
      references XEEST_ESTAD (XEEST_CODIGO)
go

alter table XEUXP_USUPE
   add constraint FK_XEUXP_US_XR_XEPER__XEPER_PE foreign key (XEPER_CODIGO)
      references XEPER_PERFI (XEPER_CODIGO)
go

alter table XEUXP_USUPE
   add constraint FK_XEUXP_US_XR_XEUSU__XEUSU_US foreign key (XEUSU_PASWD)
      references XEUSU_USUAR (XEUSU_PASWD)
go

