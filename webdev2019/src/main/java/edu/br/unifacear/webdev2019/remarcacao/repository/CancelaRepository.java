package edu.br.unifacear.webdev2019.remarcacao.repository;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;

public interface CancelaRepository extends JpaRepository<Cancela, Long>{
	
<<<<<<< HEAD
	Cancela findByGuidUsuario(Long guidUsuario);
	
	List<Cancela> findByGuidReserva(Long guidReserva);
	
	Cancela findByGuidPassagem(Long guidPassagem);
	
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
}
