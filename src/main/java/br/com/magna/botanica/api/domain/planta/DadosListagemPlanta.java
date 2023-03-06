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
		this(planta.getId(), planta.getNome(), planta.getCor(), planta.getId_filo().getId(),
				 planta.getClasse_id().getId(), planta.getOrdem_id().getId(),
				planta.getRaiz_id().getId(), planta.getCaule_id().getId(), planta.getFolhagem_id().getId(),planta.getAtivo()

		);

	}

}
