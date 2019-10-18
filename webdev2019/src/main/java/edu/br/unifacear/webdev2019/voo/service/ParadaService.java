package edu.br.unifacear.webdev2019.voo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.voo.entity.Parada;
import edu.br.unifacear.webdev2019.voo.repository.ParadaRepository;


@Service
public class ParadaService {
	@Autowired
	private ParadaRepository paradaRepository;

	@Transactional
	public void salvar(Parada parada) {
		paradaRepository.save(parada);
	}

	public void excluir(Parada parada) {
		paradaRepository.delete(parada);
	}

	public List<Parada> listar() {
		return paradaRepository.findAll();
	}

	public Parada burcarPorId(final Long guidParada) {
		Parada parada = Optional.ofNullable(paradaRepository.findById(guidParada)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR103));
		return parada;
	}
}