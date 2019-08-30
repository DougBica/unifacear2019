package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;
import edu.br.unifacear.webdev2019.remarcacao.service.exceptions.ObjectNotFoundException;

@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> find(){
		 return repo.findAll();
	}
	
	public Cancela findById(Long guidCancela) {
		Optional<Cancela> obj = repo.findById(guidCancela);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+guidCancela));
	}
	
	
	public Cancela save(Cancela obj) {
		return repo.save(obj);
	}
	
	public void delete(Long guidCancela) {
		findById(guidCancela);
		try {
			repo.deleteById(guidCancela);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
