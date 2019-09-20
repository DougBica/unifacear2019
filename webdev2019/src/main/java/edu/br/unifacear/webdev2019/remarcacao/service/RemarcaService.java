package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.Date;
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
	
	public Remarca findById(Long guidCancela) {
		Remarca remaraca = Optional.ofNullable(repo.findById(guidCancela))
				.orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return remaraca;
	}
	
	public Remarca save(Remarca obj) {
		return repo.save(obj);
	}
	
	public void delete(Long guidRemarca) {
		findById(guidRemarca);
		try {
			repo.deleteById(guidRemarca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Remarca update(Remarca obj) {
		findById(obj.getGuidRemarcar());
		return repo.save(obj);
	}
	
	public Remarca findByGuidUsuario(Long guidUsuario) {
		return repo.findByGuidUsuario(guidUsuario);
	}
	
	public List<Remarca> findByGuidReserva(Long guidReserva) {
		return repo.findByGuidReserva(guidReserva);
	}
	
	public Remarca findByGuidPassagem(Long guidPassagem) {
		return repo.findByGuidPassagem(guidPassagem);
	}
	
	public Remarca findByDataPasagem(Date dataPassagem) {
		return repo.findByDataPassagem(dataPassagem);
	}
}
