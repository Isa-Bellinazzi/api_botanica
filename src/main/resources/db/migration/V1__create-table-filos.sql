create table filos(
	id bigserial NOT NULL, 
	descricao varchar(50)  NOT NULL UNIQUE,
	folhas_verdadeiras bool NOT NULL,
    caule_verdadeiro bool  NOT NULL,
    raiz_verdadeiras bool  NOT NULL,
    frutos bool  NOT NULL,
    flores bool  NOT NULL,
    sementes bool  NOT NULL,
    ativo bool  NOT NULL,
	CONSTRAINT filos_pk PRIMARY KEY (id)
);