package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Caule;
import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.model.Folhagem;
import br.com.magna.botanica.api.model.Ordem;
import br.com.magna.botanica.api.model.Raiz;

public record DadosPlanta(
		String nome, 
		String cor, 
		Filo filo, 
		Classe classe, 
		Ordem ordem,
		Raiz raiz, 
		Caule caule, 
		Folhagem folhagem) {

}
