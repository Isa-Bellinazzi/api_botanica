create table classes(
	id bigserial NOT NULL,
	descricao varchar(50) NOT NULL,
	id_filo INTEGER REFERENCES filos(id) NOT NULL,
	ativo bool NOT NULL,
	CONSTRAINT classes_pk PRIMARY KEY (id)
);