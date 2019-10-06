package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;


@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> find(){
		List<Cancela> lista = Optional.ofNullable(repo.findAll()).
				orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000)) ;
		return lista;
	}

	public Cancela findById(Long guidCancela) {
		Cancela cancela = Optional.ofNullable(repo.findById(guidCancela))
				.orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR600));
		return cancela;
	}
		
	public void save(Cancela obj) {
		if(obj.getCheckin()) {
			Optional.ofNullable(null)
			.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR605));
		}
		else {
			Optional.ofNullable(repo.save(obj))
			.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR601));			
		}
	}
	
	public void delete(Long guidCancela) {
		findById(guidCancela);
		try {
			repo.deleteById(guidCancela);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.ERR602);
		}
	} 
	
	public Cancela update(Cancela cancela) {
		findById(cancela.getGuidCancelar());
		return repo.save(cancela);
	}
	
	public Cancela findByGuidUsuario(Long guidUsuario) {
		Cancela obj = Optional.ofNullable(repo.findByGuidUsuario(guidUsuario))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR301));
		return obj;
	}
	
	public List<Cancela> findByGuidReserva(Long guidReserva) {
		List<Cancela> lista = Optional.ofNullable(repo.findByGuidReserva(guidReserva))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR603));
		return lista;
	}
	
	public Cancela findByGuidPassagem(Long guidPassagem) {
		Cancela cancela = Optional.ofNullable(repo.findByGuidPassagem(guidPassagem))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR604));
		return cancela;
	}
	
}