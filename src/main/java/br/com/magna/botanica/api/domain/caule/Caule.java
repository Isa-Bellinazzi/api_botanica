package br.com.magna.botanica.api.domain.caule;
import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.filo.Filo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "caules")
@Entity(name = "Caule")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Caule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@OneToOne(targetEntity = Classe.class)
	@JoinColumn(name = "classe_id")
	private Classe classe_id;
	private Boolean ativo;
}
