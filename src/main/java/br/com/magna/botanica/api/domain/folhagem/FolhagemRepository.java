package br.com.magna.botanica.api.domain.folhagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FolhagemRepository extends JpaRepository<Folhagem, Long>{

	Page<Folhagem> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT f FROM Folhagem f
			WHERE
			(f.ativo = true)
			and
			(f.id = :folhagemId)
			and
			(f.classeId.id = :classeId)
			""")
	Folhagem validandoFolhaComClasse(Long folhagemId, Long classeId);


}
