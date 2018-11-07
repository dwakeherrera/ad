create table categoria (
 id serial primary key,
 nombre varchar(50) not null unique
);

insert into categoria (nombre) values ('categoria1');
insert into categoria (nombre) values ('categoria2');
insert into categoria (nombre) values ('categoria3');

create table articulo (
 id serial primary key,
 nombre varchar(50) not null unique,
 precio numeric(10,2) not null,
 categoria bigint unsigned
);

alter table articulo add foreign key (categoria) references categoria (id);

insert into articulo (nombre, precio, categoria) values ('artículo 1', 1.0, 1);
insert into articulo (nombre, precio, categoria) values ('artículo 2', 2.0, 2);
insert into articulo (nombre, precio, categoria) values ('artículo 3', 3.0, 3);
insert into articulo (nombre, precio) values ('artículo 4', 4.0);
