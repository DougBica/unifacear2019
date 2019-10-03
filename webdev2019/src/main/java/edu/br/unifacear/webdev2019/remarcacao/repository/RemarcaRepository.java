package edu.br.unifacear.webdev2019.remarcacao.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;

public interface RemarcaRepository extends JpaRepository<Remarca, Long>{

	Remarca findByGuidUsuario(Long guidUsuario);
	
	List<Remarca> findByGuidReserva(Long guidReserva);
	
	Remarca findByGuidPassagem(Long guidPassagem);
	
	Remarca findByDataPassagem(Date dataPassagem);
}
