package edu.br.unifacear.webdev2019.remarcacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;

public interface RemarcaRepository extends JpaRepository<Remarca, Long>{

	Remarca findByGuidUsuario(Long guidUsuario);
	
	Remarca findByGuidReserva(Long guidReserva);
	
	Remarca findByGuidPassagem(Long guidPassagem);
	
}
