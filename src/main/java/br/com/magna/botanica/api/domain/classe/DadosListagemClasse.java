package br.com.magna.botanica.api.domain.classe;

public record DadosListagemClasse(
		Long id,
		String descricao,
		Long filoId,
        Boolean ativo
         ) {
	

	public DadosListagemClasse(Classe classe) {
		this(classe.getId(), classe.getDescricao(), classe.getIdFilo().getId(), classe.getAtivo());
}
}
