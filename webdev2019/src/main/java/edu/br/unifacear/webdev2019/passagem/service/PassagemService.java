	package edu.br.unifacear.webdev2019.passagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.repository.PassagemRepository;

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
	public Passagem burcarPorId(final Long guidPassagem) {
		Passagem passagem = Optional.ofNullable(passagemRepository.findById(guidPassagem)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return passagem;
	}
}
