package br.com.magna.botanica.api.domain.folhagem;


public record DadosDetalhamentoFolhagem(
		Long id,
        String descricao,
        Long classeId,
        Boolean ativo
        ) {

	public DadosDetalhamentoFolhagem(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(),folha.getClasseId().getId(),folha.getAtivo());
	}
}
