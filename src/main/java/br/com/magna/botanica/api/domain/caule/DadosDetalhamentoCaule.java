package br.com.magna.botanica.api.domain.caule;

public record DadosDetalhamentoCaule(
		Long id,
        String descricao,
        Long classeId,
        Boolean ativo
        ) {

	public DadosDetalhamentoCaule(Caule caule) {
		this(caule.getId(), caule.getDescricao(), caule.getClasseId().getId(),caule.getAtivo());
	}
}
