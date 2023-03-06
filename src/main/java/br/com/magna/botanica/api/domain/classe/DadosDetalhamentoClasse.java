package br.com.magna.botanica.api.domain.classe;


public record DadosDetalhamentoClasse(
		Long id,
        String descricao,
        Long idFilo,
        Boolean ativo
        ) {

	public DadosDetalhamentoClasse(Classe classe) {
		this(classe.getId(), classe.getDescricao(), classe.getIdFilo().getId(),classe.getAtivo());
	}
}
