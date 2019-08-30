package edu.br.unifacear.webdev2019.veiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.veiculo.entity.Veiculo;
import edu.br.unifacear.webdev2019.veiculo.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRep;
	
	public void salvar(Veiculo veiculo) {
		veiculoRep.save(veiculo);
	}

	public List<Veiculo> listar() {
		return veiculoRep.findAll();
	}
	
	public Veiculo buscarPorId(Long guidVeiculo) {
		return veiculoRep.findById(guidVeiculo).get();
	}
}
