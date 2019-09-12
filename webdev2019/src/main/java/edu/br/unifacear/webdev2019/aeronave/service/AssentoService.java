package edu.br.unifacear.webdev2019.aeronave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.entity.Assento;
import edu.br.unifacear.webdev2019.aeronave.repository.AeronaveRepository;
import edu.br.unifacear.webdev2019.aeronave.repository.AssentoRepository;



@Service
public class AssentoService {

	@Autowired
	private AssentoRepository assentoRepository;
	
	public void salvar(Assento assento) {
		//if (usuario.getIdade() == null
		//		&& usuario.getIdade() < 18) {
			//lançar uma excecao 
		//}		
		assentoRepository.save(assento);
	}
	
	public List<Assento> listar() {
		return assentoRepository.findAll();
	}

	public Assento findOneById(Long guidAssento) {
		return assentoRepository.findById(guidAssento).get();
	}
}
