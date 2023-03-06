package br.com.magna.botanica.api.domain.planta;

import br.com.magna.botanica.api.domain.caule.Caule;
import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.filo.Filo;
import br.com.magna.botanica.api.domain.folhagem.Folhagem;
import br.com.magna.botanica.api.domain.ordem.Ordem;
import br.com.magna.botanica.api.domain.raiz.Raiz;

public record DadosDetalhamentoPlanta(
		Long id,
		String nome,
		String cor,
		Long id_filo,
		Long id_classe, 
		Long id_ordem,
		Long id_raiz, 
		Long id_caule,
		Long id_folhagem,
		Boolean ativo

)
{

	public DadosDetalhamentoPlanta(Planta planta) {
		this(planta.getId(), planta.getNome(), planta.getCor(), planta.getIdFilo().getId(), planta.getClasseId().getId(),
				planta.getOrdemId().getId(), planta.getRaizId().getId(), planta.getCauleId().getId(),
				planta.getFolhagemId().getId(), planta.getAtivo());
	}

	



}
