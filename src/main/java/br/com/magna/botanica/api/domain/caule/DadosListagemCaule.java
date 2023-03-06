package br.com.magna.botanica.api.domain.caule;


public record DadosListagemCaule(
		Long id,
		String descricao,
		Long classe_id,
        Boolean ativo
         ) {
	

	public DadosListagemCaule(Caule caule) {
		this(caule.getId(), caule.getDescricao(), caule.getClasse_id(), caule.getAtivo());
}
}