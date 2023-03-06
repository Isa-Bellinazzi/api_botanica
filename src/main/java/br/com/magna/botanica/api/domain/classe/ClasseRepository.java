package br.com.magna.botanica.api.domain.classe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClasseRepository extends JpaRepository<Classe, Long>{

	Page<Classe> findAllByAtivoTrue(Pageable paginacao);

	/*@Query("""
			SELECT C FROM CLASSES C
			WHERE
			""")
	Classe validandoClasseComFilo(Long classe_id, Long filo_id);*/


}
