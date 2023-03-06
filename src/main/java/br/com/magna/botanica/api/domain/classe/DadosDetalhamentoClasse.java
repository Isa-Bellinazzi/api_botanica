package br.com.magna.botanica.api.domain.classe;


public record DadosDetalhamentoClasse(
		Long id,
        String descricao,
        Long id_filo,
        Boolean ativo
        ) {

	public DadosDetalhamentoClasse(Classe classe) {
		this(classe.getId(), classe.getDescricao(), classe.getId_filo().getId(),classe.getAtivo());
	}
}
