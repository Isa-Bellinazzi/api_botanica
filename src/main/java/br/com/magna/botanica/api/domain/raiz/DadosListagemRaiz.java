package br.com.magna.botanica.api.domain.raiz;

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