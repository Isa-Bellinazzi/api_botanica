create table plantas(
	id bigserial NOT NULL,
	nome varchar(50) NOT NULL,
	cor varchar(50) NOT NULL,
	filo_id INTEGER NOT NULL,
	classe_id INTEGER NOT NULL,
	ordem_id INTEGER  NOT NULL,
	raiz_id INTEGER NOT NULL,
	caule_id INTEGER NOT NULL,
	folhagem_id INTEGER NOT NULL,
	ativo bool NOT NULL,
	CONSTRAINT plantas_pk PRIMARY KEY (id)
);
