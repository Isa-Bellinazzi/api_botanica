package br.com.magna.botanica.api.domain.raiz;

public record DadosListagemRaiz(
		Long id,
		String descricao,
		Long classe_id,
        Boolean ativo
         ) {

	public DadosListagemRaiz(Raiz raiz) {
		this(raiz.getId(), raiz.getDescricao(), raiz.getClasse_id(), raiz.getAtivo());
}
}