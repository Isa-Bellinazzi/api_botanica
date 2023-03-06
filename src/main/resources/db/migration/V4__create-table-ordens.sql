create table ordens(
	id bigserial NOT NULL,
	descricao varchar(50) NOT NULL,
	classe_id INTEGER NOT NULL,
	ativo bool NOT NULL,
	CONSTRAINT ordem_pk PRIMARY KEY (id)
);