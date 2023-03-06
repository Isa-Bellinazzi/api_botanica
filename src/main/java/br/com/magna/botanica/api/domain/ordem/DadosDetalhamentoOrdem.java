package br.com.magna.botanica.api.domain.ordem;

public record DadosDetalhamentoOrdem(
		Long id,
        String descricao,
        Long classeId,
        Boolean ativo
        ) {

	public DadosDetalhamentoOrdem(Ordem ordem) {
		this(ordem.getId(), ordem.getDescricao(), ordem.getClasseId().getId(),ordem.getAtivo());
	}
}
