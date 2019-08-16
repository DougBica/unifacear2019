package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;

@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> findAll(){
		 return repo.findAll();
	}
	
	public Optional<Cancela> find(Long id) {
		return repo.findById(id);
	}
	
	public Cancela save(Cancela can) {
		return repo.save(can);
	}
}
