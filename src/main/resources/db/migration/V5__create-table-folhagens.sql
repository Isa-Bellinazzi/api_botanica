create table folhagens(
	id bigserial NOT NULL,
	descricao varchar(50) NOT NULL,
	classe_id INTEGER NOT NULL,
    ativo bool NOT NULL,
	primary key(id,classe_id)

	
);