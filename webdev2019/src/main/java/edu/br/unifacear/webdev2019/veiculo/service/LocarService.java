package edu.br.unifacear.webdev2019.veiculo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.veiculo.entity.Locar;
import edu.br.unifacear.webdev2019.veiculo.repository.LocarRepository;
@Service
public class LocarService {

	@Autowired
	private LocarRepository locarRep;
	
	public List<Locar> listar() {
		return locarRep.findAll();
	}
	public void salvar(Locar locar) {
		locarRep.save(locar);
	}
	
	public Locar buscarPorId(Long guidLocar) {
		return locarRep.findById(guidLocar).get();
	}

}
