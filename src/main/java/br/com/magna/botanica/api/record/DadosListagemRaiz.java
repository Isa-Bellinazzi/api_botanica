package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Raiz;

public record DadosListagemRaiz(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemRaiz(Raiz raiz) {
		this(raiz.getId(), raiz.getDescricao(), raiz.getClasseId().getId(), raiz.getAtivo());
}
}