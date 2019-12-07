	package edu.br.unifacear.webdev2019.passagem.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.dto.PassagensUsuario;
import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.repository.PassagemRepository;
import edu.br.unifacear.webdev2019.passagem.repository.ReservaRepository;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.voo.entity.Rota;
import edu.br.unifacear.webdev2019.voo.service.RotaService;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private RotaService rotaService;
	
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

	public void salvarEmLote(PassagensUsuario usuarioPassagem) {
		Usuario user = usuarioPassagem.getUser();
		Reserva reserva = new Reserva(usuarioPassagem.getUser().getGuidUsuario(), usuarioPassagem.getListaPassagens());
		usuarioPassagem.getListaPassagens().forEach(passagem -> passagem.setReserva(reserva));
		Optional.ofNullable(reserva).orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR512));
		try {			
			reservaRepository.save(reserva);
			passagemRepository.saveAll(usuarioPassagem.getListaPassagens());
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionCode.ERR512);
		}
	}
	
	public Checkin gerarCheckin(Usuario user, Passagem pas) {
		Checkin check = new Checkin();
		check.setToken(gerarToken());
		check.setGuidVoo(buscarGuidVoo(pas.getGuidRota()));
		return null;
	}
	
	public String gerarToken() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
	
	public Long buscarGuidVoo(Long rotaId) {
		Rota rota = rotaService.burcarPorId(rotaId);
		
		return null;
	}
	
	public Optional<Passagem> getById(Long id) {
		return passagemRepository.findOne(id);
	}
//	public boolean existeReserva(final Long guidReserva) {
//		return passagemRepository.existsPassagemReserva_GuidReserva(guidReserva);
//	}
}
