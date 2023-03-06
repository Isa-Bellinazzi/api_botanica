package br.com.magna.botanica.api.domain.filo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiloRepository extends JpaRepository<Filo, Long>{

	Page<Filo> findAllByAtivoTrue(Pageable paginacao);


}
