package br.com.magna.botanica.api.domain.caule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CauleRepository extends JpaRepository<Caule, Long>{

	Page<Caule> findAllByAtivoTrue(Pageable paginacao);


}
