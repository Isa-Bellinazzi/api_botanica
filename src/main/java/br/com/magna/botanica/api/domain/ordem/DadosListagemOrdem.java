package br.com.magna.botanica.api.domain.ordem;

public record DadosListagemOrdem(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {

	public DadosListagemOrdem(Ordem ordem) {
		this(ordem.getId(), 
			 ordem.getDescricao(), 
			 ordem.getClasseId().getId(), 
			 ordem.getAtivo());
}
}