package br.com.magna.botanica.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlanta(
		@NotNull
		Long id,
	    @NotBlank(message = "{nome.obrigatorio}")
		String nome,
	    @NotBlank(message = "{cor.obrigatorio}")
		String cor,
		@NotNull(message = "{filo.obrigatorio}")   
		Long filoId,
		@NotNull(message = "{classe.obrigatorio}") 
		Long classeId,
		@NotNull
		Long ordemId,
	    @NotNull(message = "{raiz.obrigatorio}")  
		Long raizId,
	    @NotNull(message = "{caule.obrigatorio}")  
		Long cauleId,
	    @NotNull(message = "{folhagem.obrigatorio}")  
		Long folhagemId
) {

}
