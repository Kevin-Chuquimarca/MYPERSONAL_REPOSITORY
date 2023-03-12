create table alumno (
  alumno_id         int primary key, 
  nombre            varchar(20), 
  primer_apellido   varchar(20), 
  segundo_apellido  varchar(20), 
  email             varchar(100)
);
--2
create table telefono_type (
  telefono_type_id      int primary key,
  telefono_type_cd      char(1),
  telefono_type_text    varchar(20)
);
--3
create table telefono (
  telefono_id       int primary key, 
  telefono_type_id  int references telefono_type, 
  alumno_id         int references alumno
);
--4
create table direccion_type (
  direccion_type_id     int primary key,
  direccion_type_code   char(1),
  direccion_type_text   varchar(20)
);
--5
create table es_prov (
  es_prov_id    int primary key, 
  es_prov_cd    char(2) not null,
  es_prov_nm    varchar(30) not null
);
--6
create table es_ciudad (
  es_ciudad_id  int primary key not null,
  es_ciudad_nm  varchar(30),
  cp            char(5),
  es_prov_id    int references es_prov
);

alter table es_ciudad add constraint sql80 
  foreign key (es_prov_id) 
  references es_prov(es_prov_id) on delete no action on update no action;

create index sql80 on es_ciudad(es_prov_id);
create unique index sql801 on es_ciudad(es_ciudad_id);
---7
create table direccion (
  direccion_id      int primary key, 
  direccion_type_id int references direccion_type, 
  alumno_id         int references alumno,
  direc_linea1      varchar(100),
  direc_linea2      varchar(100),
  ciudad            varchar(100),
  cp                char(5),
  es_prov_id        int references es_prov
);
--8
create table item (
  item_id           int primary key, 
  item_numero       varchar(10), 
  item_short_desc   varchar(100), 
  item_long_desc    varchar(100)
);
--9
create table alumno_order (
  alumno_order_id   int primary key,
  alumno_id         int references alumno,
  order_numero      varchar(100),
  order_description varchar(100),
  item_id           int references item
);
--10
create table order_item (
  alumno_order_id   int references alumno_order, 
  item_id           int references item
);
--11
create table app_usuario (
  app_usuario_id    int primary key, 
  usuario_name      varchar(10), 
  password          varchar(15)
);
--12
create table app_usuario_role (
  role_id   int primary key, 
  role_name varchar(10)
);
--13
create table sequence (
  seq_name  varchar(50), 
  seq_count decimal(15)
);

insert into telefono_type(telefono_type_id, telefono_type_cd, telefono_type_text)
  values (1, 'C', 'Casa');
insert into telefono_type(telefono_type_id, telefono_type_cd, telefono_type_text)
  values (2, 'T', 'Trabajo');
insert into telefono_type(telefono_type_id, telefono_type_cd, telefono_type_text)
  values (3, 'M', 'Movil');

insert into direccion_type (direccion_type_id, direccion_type_code, direccion_type_text)
  values (1, 'C', 'Casa');
insert into direccion_type (direccion_type_id, direccion_type_code, direccion_type_text)
  values (2, 'M', 'Mailing');
insert into direccion_type (direccion_type_id, direccion_type_code, direccion_type_text)
  values (3, 'S', 'Shipping');

insert into es_prov (es_prov_id, es_prov_cd, es_prov_nm)
  values (1, 'PA', 'Pasto');
insert into es_prov (es_prov_id, es_prov_cd, es_prov_nm)
  values (2, 'MD', 'Medina');

insert into sequence  (seq_name, seq_count) 
  values ('seq_gen',100);