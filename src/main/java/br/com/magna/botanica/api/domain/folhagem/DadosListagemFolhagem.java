package br.com.magna.botanica.api.domain.folhagem;

public record DadosListagemFolhagem(
		Long id,
		String descricao,
		Long classe_id,
        Boolean ativo
         ) {

	public DadosListagemFolhagem(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(), folha.getClasse_id().getId(), folha.getAtivo());
}
}