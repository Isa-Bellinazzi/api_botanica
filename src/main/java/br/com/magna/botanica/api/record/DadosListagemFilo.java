package br.com.magna.botanica.api.record;

import br.com.magna.botanica.api.model.Filo;

public record DadosListagemFilo(Long id,
        String descricao,
        Boolean folhasVerdadeiras,
        Boolean cauleVerdadeiro,
        Boolean raizVerdadeiras,
        Boolean frutos,
        Boolean flores,
        Boolean sementes

         ) {
	

	public DadosListagemFilo(Filo filo) {
		this(filo.getId(), filo.getDescricao(), filo.getFolhasVerdadeiras(), filo.getCauleVerdadeiro(),
				filo.getFolhasVerdadeiras(), filo.getFrutos(), filo.getFlores(), filo.getSementes());
}
}