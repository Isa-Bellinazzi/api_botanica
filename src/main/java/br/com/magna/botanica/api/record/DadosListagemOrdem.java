package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Ordem;

public record DadosListagemOrdem(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemOrdem(Ordem ordem) {
		this(ordem.getId(), 
			 ordem.getDescricao(), 
			 ordem.getClasseId().getId(), 
			 ordem.getAtivo());
}
}