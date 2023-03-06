package br.com.magna.botanica.api.domain.folhagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolhagemRepository extends JpaRepository<Folhagem, Long>{

	Page<Folhagem> findAllByAtivoTrue(Pageable paginacao);


}
