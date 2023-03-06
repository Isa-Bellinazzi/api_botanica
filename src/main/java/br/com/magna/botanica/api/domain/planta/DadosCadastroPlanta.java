package br.com.magna.botanica.api.domain.planta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPlanta(
	    @NotBlank(message = "{nome.obrigatorio}")
		String nome,
	    @NotBlank(message = "{cor.obrigatorio}")
		String cor,
		@NotNull   
		Long filo_id,
		@NotNull(message = "{classe.obrigatorio}") 
	    Long classe_id,
	    Long ordem_id,
	    @NotNull(message = "{raiz.obrigatorio}")  
	    Long raiz_id,
	    @NotNull(message = "{caule.obrigatorio}")  
	    Long caule_id, 
	    @NotNull(message = "{folhagem.obrigatorio}")  
	    Long folhagem_id
) {

}
