package edu.br.unifacear.webdev2019.aeronave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.entity.Assento;
import edu.br.unifacear.webdev2019.aeronave.repository.AeronaveRepository;

@Service
public class AeronaveService {

	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	@Transactional
	public void salvar(Aeronave aeronave) {
		aeronave = aeronaveRepository.save(aeronave);
		if (aeronave.getAssentos() != null) {
			for (Assento a : aeronave.getAssentos()) {
				a.setGuidAeronave(aeronave.getGuidaeronave());
			}
		}
	}
	
	public List<Aeronave> listar() {
		return aeronaveRepository.findAll();
	}

	public Aeronave findOneById(Long guidAeronave) {
		return aeronaveRepository.findById(guidAeronave).get();
	}

	public void remover(Long guidAeronave) {
		aeronaveRepository.deleteById(guidAeronave);
	}
}
