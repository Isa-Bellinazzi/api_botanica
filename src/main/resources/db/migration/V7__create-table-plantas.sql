create table plantas(
	id bigserial NOT NULL,
	nome varchar(50) NOT NULL UNIQUE,
	cor varchar(50) NOT NULL,
	filo_id INTEGER REFERENCES filos(id) NOT NULL,
	classe_id INTEGER REFERENCES classes(id) NOT NULL,
	ordem_id INTEGER REFERENCES ordens(id),
	raiz_id INTEGER REFERENCES raizes(id) NOT NULL,
	caule_id INTEGER REFERENCES caules(id) NOT NULL,
	folhagem_id INTEGER REFERENCES folhagens(id) NOT NULL,
	ativo bool NOT NULL,
	CONSTRAINT plantas_pk PRIMARY KEY (id)
);