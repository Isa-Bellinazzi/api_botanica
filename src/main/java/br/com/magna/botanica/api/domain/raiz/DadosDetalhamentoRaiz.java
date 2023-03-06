package br.com.magna.botanica.api.domain.raiz;

public record DadosDetalhamentoRaiz(
		Long id,
        String descricao,
        Long classeId,
        Boolean ativo
        ) {

	public DadosDetalhamentoRaiz(Raiz raiz) {
		this(raiz.getId(), raiz.getDescricao(), raiz.getClasseId().getId(),raiz.getAtivo());
	}
}
