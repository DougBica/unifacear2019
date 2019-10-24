package edu.br.unifacear.webdev2019.voo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.voo.entity.Aeroporto;
import edu.br.unifacear.webdev2019.voo.repository.AeroportoRepository;

@Service
public class AeroportoService {
	@Autowired
	private AeroportoRepository aeroportoRepository;

	@Transactional
	public void salvar(Aeroporto aeroporto) {
		aeroportoRepository.save(aeroporto);
	}

	public void excluir(Aeroporto aeroporto) {
		aeroportoRepository.delete(aeroporto);
	}

	public List<Aeroporto> listar() {
		return aeroportoRepository.findAll();
	}

	public Aeroporto burcarPorId(final Long guidAeroporto) {
		Aeroporto aeroporto = Optional.ofNullable(aeroportoRepository.findById(guidAeroporto)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR101));
		return aeroporto;
	}
}
