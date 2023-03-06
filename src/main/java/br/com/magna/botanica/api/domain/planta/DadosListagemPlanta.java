package br.com.magna.botanica.api.domain.planta;

public record DadosListagemPlanta(
Long id,
String nome,
String cor, 
Long id_filo,
Long id_classe, 
Long id_ordem,
Long id_raiz, 
Long id_caule,
Long id_folhagem,
Boolean ativo) {

	public DadosListagemPlanta(Planta planta) {
		this(planta.getId(), planta.getNome(), planta.getCor(), planta.getIdFilo().getId(),
				 planta.getCauleId().getId(), planta.getOrdemId().getId(),
				planta.getRaizId().getId(), planta.getCauleId().getId(), planta.getFolhagemId().getId(),planta.getAtivo()

		);

	}

}
