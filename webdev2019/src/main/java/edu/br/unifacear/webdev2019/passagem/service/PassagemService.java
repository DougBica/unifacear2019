	package edu.br.unifacear.webdev2019.passagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.repository.PassagemRepository;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Transactional
	public void salvar(Passagem passagem) {	
//		RestTemplate rt = new RestTemplate();
//		try {
//			Reserva res = rt.getForObject("http://localhost:8080/reserva/"+passagem.getReserva().getGuidReserva(),Reserva.class);
//		} catch (HttpClientErrorException  e) {
//			if(e.getMessage().contains("null")) throw new BusinessException(BusinessExceptionCode.ERR502);
//		}
		passagemRepository.save(passagem);
	}
	
	public List<Passagem> listar() {
		return passagemRepository.findAll();
	}

	
	public void excluir(Passagem passagem) {
		passagemRepository.delete(passagem);
	}
	
	public List<Passagem> listarPorReserva(final Long guidReserva) {
		List<Passagem> listaPassagens = passagemRepository.findPassagemByReserva_GuidReserva(guidReserva);
		if (listaPassagens.isEmpty()) throw new BusinessException(BusinessExceptionCode.ERR504);
		return listaPassagens;
	}
	public Passagem burcarPorId(final Long guidPassagem) {
		Passagem passagem = Optional.ofNullable(passagemRepository.findById(guidPassagem)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return passagem;
	}
	
//	public boolean existeReserva(final Long guidReserva) {
//		return passagemRepository.existsPassagemReserva_GuidReserva(guidReserva);
//	}
}
