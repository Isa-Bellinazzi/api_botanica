package br.com.magna.botanica.api.domain.planta;

public record DadosDetalhamentoPlanta(
		Long id,
		String nome,
		String cor,
		Long id_filo,
		Long id_classe, 
		Long id_ordem,
		Long id_raiz, 
		Long id_caule,
		Long id_folhagem,
		Boolean ativo

)
{

	public DadosDetalhamentoPlanta(Planta planta) {
		this(planta.getId(), planta.getNome(), planta.getCor(), planta.getFilo_id(), planta.getClasse_id(),
				planta.getOrdem_id(), planta.getRaiz_id(), planta.getCaule_id(),
				planta.getFolhagem_id(), planta.getAtivo());
	}

}
