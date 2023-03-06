package br.com.magna.botanica.api.domain.folhagem;

public record DadosListagemFolhagem(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemFolhagem(Folhagem folha) {
		this(folha.getId(), folha.getDescricao(), folha.getClasseId().getId(), folha.getAtivo());
}
}