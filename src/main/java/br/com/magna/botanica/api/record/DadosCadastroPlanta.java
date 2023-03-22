package br.com.magna.botanica.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPlanta(
	    @NotBlank(message = "{nome.obrigatorio}")
		String nome,
	    @NotBlank(message = "{cor.obrigatorio}")
		String cor,
		@NotNull   
		Long filoId,
		@NotNull(message = "{classe.obrigatorio}") 
	    Long classeId,
	    @NotNull(message = "{ordem.obrigatorio}")
	    Long ordemId,
	    @NotNull(message = "{raiz.obrigatorio}")  
	    Long raizId,
	    @NotNull(message = "{caule.obrigatorio}")  
	    Long cauleId, 
	    @NotNull(message = "{folhagem.obrigatorio}")  
	    Long folhagemId
) {




}
