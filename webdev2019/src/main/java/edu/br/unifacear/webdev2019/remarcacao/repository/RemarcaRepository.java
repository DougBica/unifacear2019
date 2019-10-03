package edu.br.unifacear.webdev2019.remarcacao.repository;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;

public interface RemarcaRepository extends JpaRepository<Remarca, Long>{

<<<<<<< HEAD
	Remarca findByGuidUsuario(Long guidUsuario);
	
	List<Remarca> findByGuidReserva(Long guidReserva);
	
	Remarca findByGuidPassagem(Long guidPassagem);
	
	Remarca findByDataPassagem(Date dataPassagem);
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
}
