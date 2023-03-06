package br.com.magna.botanica.api.domain.ordem;

public record DadosDetalhamentoOrdem(
		Long id,
        String descricao,
        Long classe_id,
        Boolean ativo
        ) {

	public DadosDetalhamentoOrdem(Ordem ordem) {
		this(ordem.getId(), ordem.getDescricao(), ordem.getClasse_id().getId(),ordem.getAtivo());
	}
}
