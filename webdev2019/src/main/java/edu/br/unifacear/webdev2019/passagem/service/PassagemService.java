	package edu.br.unifacear.webdev2019.passagem.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.checkin.entity.StatusCheckin;
import edu.br.unifacear.webdev2019.checkin.repository.CheckinRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.dto.PassagensUsuario;
import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.repository.PassagemRepository;
import edu.br.unifacear.webdev2019.passagem.repository.ReservaRepository;
import edu.br.unifacear.webdev2019.voo.entity.Rota;
import edu.br.unifacear.webdev2019.voo.service.RotaService;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private CheckinRepository checkinRepository;
	
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
	
//	public List<Passagem> listarPorReserva(final Long guidReserva) {
//		List<Passagem> listaPassagens = passagemRepository.findPassagemByReserva_GuidReserva(guidReserva);
//		if (listaPassagens.isEmpty()) throw new BusinessException(BusinessExceptionCode.ERR504);
//		return listaPassagens;
//	}
	
	public Passagem burcarPorId(final Long guidPassagem) {
		Passagem passagem = Optional.ofNullable(passagemRepository.findById(guidPassagem)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return passagem;
	}

	public void salvarEmLote(PassagensUsuario usuarioPassagem) {
		
		logger("SALVANDO EM LOTE..");
		
		Long guidUsuario = usuarioPassagem.getUser().getGuidUsuario();
		
		Reserva reserva = new Reserva(guidUsuario, usuarioPassagem.getListaPassagens());
		
//		usuarioPassagem.getListaPassagens().forEach(passagem -> passagem.setReserva(reserva));
		
		Optional.ofNullable(reserva).orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR512));
		try {
			
			// Salvando Reserva no banco
			logger("SALVANDO RESERVA DO USUARIO: " + usuarioPassagem.getUser().getNome());
			reservaRepository.save(reserva);
			
			// Salvando Passagens e seus respectivos checkins no bancos
			for(Passagem passagem: usuarioPassagem.getListaPassagens()) {
				logger("SALVANDO PASSAGEM - CPF: " + passagem.getCpfPassageiro());
				passagem.setGuidReserva(reserva.getGuidReserva());
				passagemRepository.save(passagem);
				logger("CRIANDO CHECKIN...");
				Checkin checkin = gerarCheckin(guidUsuario, passagem);
				logger(" SALVANDO CHECKIN - CPF: " + passagem.getCpfPassageiro());
				checkinRepository.save(checkin);
			};
			
		} catch (Exception e) {
			System.out.println(e);
			throw new BusinessException(BusinessExceptionCode.ERR512);
			
		}
	}
	

	public Checkin gerarCheckin(Long guidUsuario, Passagem passagem) {

		
		Checkin checkin = new Checkin();
		
		//token: string; // precisa
		checkin.setToken(gerarToken());
		
	    //guidUsuario: number; // precisa
		checkin.setGuidUsuario(guidUsuario);
		
	    //guidPassagem: number; // precisa
		checkin.setGuidPassagem(passagem.getGuidPassagem());
		
		//guidAeronave: number; // não é possivel ainda, pois o modulo voo que tera os voos cadastrados nao esta inalizado
		
		
		checkin.setGuidStatus(1l);
		
		//checkinAtivo: boolean; // precisa 
		checkin.setCheckinAtivo(true);
		
		//dataCheckin: any; // data padrão
		checkin.setDataCheckin(new Date());
		
		return checkin;
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
	
	public void logger(String log) {
		String headerLog = "PASSAGEM SERVICE - ";
		System.out.println(headerLog + log);
	}
	

//	public boolean existeReserva(final Long guidReserva) {
//		return passagemRepository.existsPassagemReserva_GuidReserva(guidReserva);
//	}
	
}
