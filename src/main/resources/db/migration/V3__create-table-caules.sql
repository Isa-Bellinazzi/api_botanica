create table caules(
	id bigserial NOT NULL,
	descricao varchar(50) not null,
	classe_id INTEGER REFERENCES classes(id) NOT NULL,
	ativo bool NOT NULL,
	primary key(id)
);