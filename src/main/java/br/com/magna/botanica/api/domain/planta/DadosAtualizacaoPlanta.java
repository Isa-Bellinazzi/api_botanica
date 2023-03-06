package br.com.magna.botanica.api.domain.planta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlanta(
		@NotNull
		Long id,
		String nome,
		String cor,
		Long filo_id,
		Long classe_id,
		Long ordem_id,
		Long raiz_id,
		Long caule_id,
		Long folhagem_id
) {

}
