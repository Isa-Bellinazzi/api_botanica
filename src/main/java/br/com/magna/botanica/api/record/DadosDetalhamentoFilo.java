package br.com.magna.botanica.api.record;

public record DadosDetalhamentoFilo(
		String descricao,
		Boolean folhasVerdadeiras, 
		Boolean cauleVerdadeiro, 
		Boolean raizVerdadeiras,
        Boolean frutos, 
        Boolean flores, 
        Boolean ativo, 
        Boolean sementes)
	{
}
