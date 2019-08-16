package edu.br.unifacear.webdev2019.aeronave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.aeronave.entity.Fabricante;
import edu.br.unifacear.webdev2019.aeronave.repository.FabricanteRepository;
;


@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public void salvar(Fabricante fabricante) {
		//if (usuario.getIdade() == null
		//		&& usuario.getIdade() < 18) {
			//lançar uma excecao 
		//}		
		fabricanteRepository.save(fabricante);
	}
	
	public List<Fabricante> listar() {
		return fabricanteRepository.findAll();
	}
}