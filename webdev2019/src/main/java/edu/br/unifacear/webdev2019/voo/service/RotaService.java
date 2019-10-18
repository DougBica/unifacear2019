package edu.br.unifacear.webdev2019.voo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.voo.entity.Rota;
import edu.br.unifacear.webdev2019.voo.repository.RotaRepository;


@Service
public class RotaService {
	@Autowired
	private RotaRepository rotaRepository;

	@Transactional
	public void salvar(Rota rota) {
		rotaRepository.save(rota);
	}

	public void excluir(Rota rota) {
		rotaRepository.delete(rota);
	}

	public List<Rota> listar() {
		return rotaRepository.findAll();
	}

	public Rota burcarPorId(final Long guidRota) {
		Rota rota = Optional.ofNullable(rotaRepository.findById(guidRota)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR102));
		return rota;
	}
}