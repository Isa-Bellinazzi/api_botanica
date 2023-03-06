package br.com.magna.botanica.api.domain.folhagem;


public record DadosDetalhamentoFolhagem(
		Long id,
        String descricao,
        Long classe_id,
        Boolean ativo
        ) {

	public DadosDetalhamentoFolhagem(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(),folha.getClasse_id(),folha.getAtivo());
	}
}
