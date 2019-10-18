package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;
import edu.br.unifacear.webdev2019.remarcacao.repository.RemarcaRepository;


@Service
public class RemarcaService {
	
	@Autowired
	private RemarcaRepository repo;
	
	public List<Remarca> find(){
		return repo.findAll();
	}
	
	public Remarca findById(Long guidRemarca) {
		Remarca remaraca = Optional.ofNullable(repo.findById(guidRemarca))
				.orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR606));
		return remaraca;
	}
	
	public void save(Remarca obj) {
		if(obj.getCheckin()) {
			Optional.ofNullable(null)
			.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR605));
		}else {
			Optional.ofNullable(repo.save(obj))
			.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR607));
		}
	}
	
	public void delete(Long guidRemarca) {
		findById(guidRemarca);
		try {
			repo.deleteById(guidRemarca);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.ERR608);
		}
	} 
	
	public Remarca update(Long guidRemarca) {
		Remarca obj = findById(guidRemarca);
		return repo.save(obj);
	}
	
	public Remarca findByGuidUsuario(Long guidUsuario) {
		Remarca remarca = Optional.ofNullable(repo.findByGuidUsuario(guidUsuario))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR301));
		return remarca;
	}
	
	public Remarca findByGuidReserva(Long guidReserva) {
		Remarca remarca = Optional.ofNullable(repo.findByGuidReserva(guidReserva))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR603));
		return remarca;
	}
	
	public Remarca findByGuidPassagem(Long guidPassagem) {
		Remarca remarca = Optional.ofNullable(repo.findByGuidPassagem(guidPassagem))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR604));
		return remarca;
	}	
}