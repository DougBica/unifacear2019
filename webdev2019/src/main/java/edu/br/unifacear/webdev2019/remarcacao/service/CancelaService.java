package edu.br.unifacear.webdev2019.remarcacao.service;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Date;
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;
=======
import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;
import edu.br.unifacear.webdev2019.remarcacao.service.exceptions.ObjectNotFoundException;
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2

@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> find(){
		 return repo.findAll();
	}
<<<<<<< HEAD

	public Cancela findById(Long guidCancela) {
		Cancela cancela = Optional.ofNullable(repo.findById(guidCancela))
				.orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return cancela;
	}
	
=======
	
	public Cancela findById(Long guidCancela) {
		Optional<Cancela> obj = repo.findById(guidCancela);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+guidCancela));
	}
		
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
	public Cancela save(Cancela obj) {
		return repo.save(obj);
	}
	
	public void delete(Long guidCancela) {
<<<<<<< HEAD
	  findById(guidCancela);
=======
		findById(guidCancela);
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
		try {
			repo.deleteById(guidCancela);
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
	} 
	
	public Cancela update(Cancela cancela) {
		findById(cancela.getGuidCancelar());
		return repo.save(cancela);
	}
	
	public Cancela findByGuidUsuario(Long guidUsuario) {
		return repo.findByGuidUsuario(guidUsuario);
	}
	
	public List<Cancela> findByGuidReserva(Long guidReserva) {
		return repo.findByGuidReserva(guidReserva);
	}
	
	public Cancela findByGuidPassagem(Long guidPassagem) {
		return repo.findByGuidPassagem(guidPassagem);
	}
=======
	}
	
	public List<Cancela> findByDate(Date init, Date end){
		List<Cancela> list = find();
		List<Cancela> list_date = new ArrayList<>();
		for(Cancela c: list  ){
			if( c.getDataCancelamento().before(end) && c.getDataCancelamento().after(init) ) {
				list_date.add(c);
			}
		}
		return list_date;
	}

>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
}
