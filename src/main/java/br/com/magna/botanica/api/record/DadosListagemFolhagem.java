package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Folhagem;

public record DadosListagemFolhagem(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemFolhagem(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(), folha.getClasseId().getId(), folha.getAtivo());
}
}