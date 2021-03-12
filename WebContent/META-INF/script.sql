use crud_db;
create table contatos(
	id int primary key auto_increment,
	nome varchar(150) not null,
	email varchar(150) not null unique,
	telefone varchar(15) not null
);