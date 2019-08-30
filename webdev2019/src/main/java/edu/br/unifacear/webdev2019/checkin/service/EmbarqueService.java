package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.Embarque;
import edu.br.unifacear.webdev2019.checkin.repository.EmbarqueRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;

@Service
public class EmbarqueService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	EmbarqueRepository embarqueRepository;
	
	public List<Embarque> listarAll() {
		try {
			return embarqueRepository.findAll();
		}
		catch(BusinessException e){
			throw new BusinessException(BusinessExceptionCode.ERR000);
		}
	}
	
	public Embarque listarOne(Long id) {
		Embarque embarque = Optional.ofNullable(embarqueRepository.findById(id)).orElse(null).
				orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR000));
		return embarque;
	}
	
	public Embarque inserirEmbarque(Embarque embarque) {
		return embarqueRepository.save(embarque);
	}
	
	public Embarque alterarEmbarque(Embarque embarque) {
		return embarqueRepository.save(embarque);
	}
	
	public void deletarEmbarque(Embarque embarque) {
		embarqueRepository.delete(embarque);
	}
	
}
