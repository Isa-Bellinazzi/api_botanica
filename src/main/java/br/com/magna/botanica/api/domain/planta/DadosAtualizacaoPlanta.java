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
		Long filoId,
		@NotNull
		Long classeId,
		@NotNull
		Long ordemId,
		@NotNull
		Long raizId,
		@NotNull
		Long cauleId,
		@NotNull
		Long folhagemId
) {

}
