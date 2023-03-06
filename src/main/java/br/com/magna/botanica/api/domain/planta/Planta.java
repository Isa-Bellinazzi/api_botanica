package br.com.magna.botanica.api.domain.planta;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "plantas")
@Entity(name = "Planta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cor;
	private Long filo_id;
	private Long classe_id;
	private Long ordem_id;
	private Long raiz_id;
	private Long caule_id;
	private Long folhagem_id;
	private Boolean ativo;


	public Planta(DadosCadastroPlanta dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.cor = dados.cor();
		this.filo_id = dados.filo_id();
		this.classe_id = dados.classe_id();
		this.ordem_id = dados.ordem_id();
		this.raiz_id = dados.raiz_id();
		this.caule_id = dados.caule_id();
		this.folhagem_id = dados.folhagem_id();

	}

	public void atualizarInformacoes(DadosAtualizacaoPlanta dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.cor() != null) {
			this.cor = dados.cor();
		}
		if(dados.filo_id() != null) {
			this.filo_id = dados.filo_id();
		}
		if(dados.classe_id() != null) {
			this.classe_id = dados.classe_id();
		}
		if(dados.ordem_id() != null) {
			this.ordem_id = dados.ordem_id();
		}
		if(dados.raiz_id() != null) {
			this.raiz_id = dados.raiz_id();
		}
		if(dados.caule_id() != null) {
			this.caule_id = dados.caule_id();
		}
		if(dados.folhagem_id() != null) {
			this.folhagem_id = dados.folhagem_id();
		}
	}
	
	public void excluir() {
		this.ativo = false;
	}

	public Boolean getAtivo() {
		return ativo;
	}
}

