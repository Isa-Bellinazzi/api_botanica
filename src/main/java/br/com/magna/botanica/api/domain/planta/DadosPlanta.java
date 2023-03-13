package br.com.magna.botanica.api.domain.planta;

import br.com.magna.botanica.api.domain.caule.Caule;
import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.filo.Filo;
import br.com.magna.botanica.api.domain.folhagem.Folhagem;
import br.com.magna.botanica.api.domain.ordem.Ordem;
import br.com.magna.botanica.api.domain.raiz.Raiz;

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
