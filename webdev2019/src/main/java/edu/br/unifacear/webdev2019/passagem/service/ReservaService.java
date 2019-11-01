package edu.br.unifacear.webdev2019.passagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;
	
	private String headerLog = "RESERVA SERVICE - ";
	
	@Transactional
	public void salvar(Reserva reserva) {
		System.out.println(headerLog + "Salvando Reserva");
		reservaRepository.save(reserva);
	}	
	
	public void excluir(Reserva reserva) {
		reservaRepository.delete(reserva);
	}
	
	public List<Reserva> listar() {
		return reservaRepository.findAll();
	}
	public Reserva buscarPorId(final Long guidReserva) {
		Reserva reserva = Optional.ofNullable(reservaRepository.findById(guidReserva)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR503));
		return reserva;
	}

	public List<Reserva> listarPorUsuario(final Long guidUsuairo) {
		List<Reserva> listaReservas = reservaRepository.findByGuidUsuario(guidUsuairo);
		if(listaReservas.isEmpty()) throw new BusinessException(BusinessExceptionCode.ERR505);
		return listaReservas;
	}
}
