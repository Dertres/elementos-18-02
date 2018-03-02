create table mensajitos(
id integer primary key auto_increment,
titulo varchar(50),
cuerpo varchar (189)
);

delete from mensajitos;
insert into mensajitos (titulo,cuerpo) values("Algo1","aaytgcba");
insert into mensajitos (titulo,cuerpo) values("Algo2","aaytgcba");
insert into mensajitos (titulo,cuerpo) values("Algo3","aaytgcba");
insert into mensajitos (titulo,cuerpo) values("Algo4","aaytgcba");
insert into mensajitos (titulo,cuerpo) values("Algo5","aaytgcba");
select * from mensajitos;