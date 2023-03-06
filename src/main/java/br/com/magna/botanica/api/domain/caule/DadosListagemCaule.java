package br.com.magna.botanica.api.domain.caule;


public record DadosListagemCaule(
		Long id,
		String descricao,
		Long classeId,
        Boolean ativo
         ) {
	

	public DadosListagemCaule(Caule caule) {
		this(caule.getId(), caule.getDescricao(), caule.getClasseId().getId(), caule.getAtivo());
}
}