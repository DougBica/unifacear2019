package edu.br.unifacear.webdev2019.aeronave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.entity.Fabricante;
import edu.br.unifacear.webdev2019.aeronave.repository.AeronaveRepository;
import edu.br.unifacear.webdev2019.aeronave.repository.FabricanteRepository;

@Service
public class AeronaveService {

	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	public void salvar(Aeronave aeronave) {
		//if (usuario.getIdade() == null
		//		&& usuario.getIdade() < 18) {
			//lançar uma excecao 
		//}		
		aeronaveRepository.save(aeronave);
	}
	
	public List<Aeronave> listar() {
		return aeronaveRepository.findAll();
	}

	public Aeronave findOneById(Long guidAeronave) {
		return aeronaveRepository.findById(guidAeronave).get();
	}
}
