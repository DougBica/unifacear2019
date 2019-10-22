package edu.br.unifacear.webdev2019.voo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.voo.entity.Voo;
import edu.br.unifacear.webdev2019.voo.repository.VooRepository;

@Service
public class VooService {
	@Autowired
	private VooRepository vooRepository;

	@Transactional
	public void salvar(Voo voo) {
		vooRepository.save(voo);
	}

	public void excluir(Voo voo) {
		vooRepository.delete(voo);
	}

	public List<Voo> listar() {
		return vooRepository.findAll();
	}

	public Voo burcarPorId(final Long guidVoo) {
		Voo voo = Optional.ofNullable(vooRepository.findById(guidVoo)).orElse(null)
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR100));
		return voo;
	}
}
