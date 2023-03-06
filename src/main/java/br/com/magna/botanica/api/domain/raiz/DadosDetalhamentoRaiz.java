package br.com.magna.botanica.api.domain.raiz;

public record DadosDetalhamentoRaiz(
		Long id,
        String descricao,
        Long classe_id,
        Boolean ativo
        ) {

	public DadosDetalhamentoRaiz(Raiz raiz) {
		this(raiz.getId(), raiz.getDescricao(), raiz.getClasse_id(),raiz.getAtivo());
	}
}
