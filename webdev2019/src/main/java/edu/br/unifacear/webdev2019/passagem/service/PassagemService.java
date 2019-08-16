package edu.br.unifacear.webdev2019.passagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.repository.PassagemRepository;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Transactional
	public void salvar(Passagem passagem) {		
		passagemRepository.save(passagem);
	}	
	
	public void excluir(Passagem passagem) {
		passagemRepository.delete(passagem);
	}
	
	public List<Passagem> listar() {
		return passagemRepository.findAll();
	}
}
