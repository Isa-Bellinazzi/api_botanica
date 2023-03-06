package br.com.magna.botanica.api.domain.filo;

public record DadosDetalhamentoFilo(
		Long id,
        String descricao,
        Boolean folhas_verdadeiras,
        Boolean caule_verdadeiro,
        Boolean raiz_verdadeiras,
        Boolean frutos,
        Boolean flores,
        Boolean sementes

        ) {

	public DadosDetalhamentoFilo(Filo filo) {
		this(filo.getId(), filo.getDescricao(), filo.getFolhas_verdadeiras(), filo.getCaule_verdadeiro(),
				filo.getRaiz_verdadeiras(), filo.getFrutos(), filo.getFlores(),filo.getSementes());
	}
}
