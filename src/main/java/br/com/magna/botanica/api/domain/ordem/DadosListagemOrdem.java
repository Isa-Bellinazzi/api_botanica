package br.com.magna.botanica.api.domain.ordem;

public record DadosListagemOrdem(
		Long id,
		String descricao,
		Long classe_id,
        Boolean ativo
         ) {

	public DadosListagemOrdem(Ordem ordem) {
		this(ordem.getId(), ordem.getDescricao(), ordem.getClasse_id().getId(), ordem.getAtivo());
}
}