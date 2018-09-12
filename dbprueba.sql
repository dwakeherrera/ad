create table categoria (
 id serial primary key,
 nombre varchar(50) not null unique
);

insert into categoria (nombre) values ('categoria1');
insert into categoria (nombre) values ('categoria2');
insert into categoria (nombre) values ('categoria3');
