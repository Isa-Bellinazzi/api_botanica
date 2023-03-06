package br.com.magna.botanica.api.domain.planta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlanta(
		@NotNull
		Long id,
		@NotBlank		
		String nome,
		@NotBlank		
		String cor,
		@NotNull
		Long filo_id,
		@NotNull
		Long classe_id,
		@NotNull
		Long ordem_id,
		@NotNull
		Long raiz_id,
		@NotNull
		Long caule_id,
		@NotNull
		Long folhagem_id
) {

}
