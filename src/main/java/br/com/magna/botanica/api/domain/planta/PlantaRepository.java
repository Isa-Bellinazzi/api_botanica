package br.com.magna.botanica.api.domain.planta;

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

	Page<Planta> findAllByAtivoTrue(Pageable paginacao);

}    
