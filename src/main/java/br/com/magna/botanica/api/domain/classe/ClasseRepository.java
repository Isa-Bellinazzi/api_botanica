package br.com.magna.botanica.api.domain.classe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.botanica.api.domain.filo.Filo;

public interface ClasseRepository extends JpaRepository<Classe, Long>{

	Page<Classe> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT  c FROM Classe c
			WHERE
			(c.ativo = 1)
			and
			(c.id = :classeId)
			and
			(c.idFilo = :idFilo)
			""")
	Classe validandoClasseComFilo(Long classeId, Long idFilo);


}
