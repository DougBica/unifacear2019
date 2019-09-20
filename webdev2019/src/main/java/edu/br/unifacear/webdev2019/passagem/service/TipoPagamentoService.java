package edu.br.unifacear.webdev2019.passagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.entity.TipoPagamento;
import edu.br.unifacear.webdev2019.passagem.repository.TipoPagamentoRepository;


@Service
public class TipoPagamentoService {

	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepository;
	
	@Transactional
	public void salvar(TipoPagamento tipoPagamento) {		
		tipoPagamentoRepository.save(tipoPagamento);
	}	
	
	public void excluir(TipoPagamento tipoPagamento) {
		tipoPagamentoRepository.delete(tipoPagamento);
	}
	
	public List<TipoPagamento> listar() {
		return tipoPagamentoRepository.findAll();
	}
	public TipoPagamento buscarPorId(final Long guidTipoPagamento) {
		TipoPagamento tipoPagamento = Optional.ofNullable(tipoPagamentoRepository.findById(guidTipoPagamento)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return tipoPagamento;
	}
	
	
}
