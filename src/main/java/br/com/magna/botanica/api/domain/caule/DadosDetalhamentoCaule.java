package br.com.magna.botanica.api.domain.caule;

public record DadosDetalhamentoCaule(
		Long id,
        String descricao,
        Long classe_id,
        Boolean ativo
        ) {

	public DadosDetalhamentoCaule(Caule caule) {
		this(caule.getId(), caule.getDescricao(), caule.getClasse_id(),caule.getAtivo());
	}
}
