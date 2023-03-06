package br.com.magna.botanica.api.domain.planta;

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
	    Long ordemId,
	    @NotNull(message = "{raiz.obrigatorio}")  
	    Long raizId,
	    @NotNull(message = "{caule.obrigatorio}")  
	    Long cauleId, 
	    @NotNull(message = "{folhagem.obrigatorio}")  
	    Long folhagemId
) {

}
