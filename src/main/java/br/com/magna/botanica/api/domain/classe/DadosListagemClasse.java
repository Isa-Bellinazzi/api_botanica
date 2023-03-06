package br.com.magna.botanica.api.domain.classe;

public record DadosListagemClasse(
		Long id,
		String descricao,
		Long filo_id,
        Boolean ativo
         ) {
	

	public DadosListagemClasse(Classe classe) {
		this(classe.getId(), classe.getDescricao(), classe.getId_filo(), classe.getAtivo());
}
}
