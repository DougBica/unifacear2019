package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.Bagagem;
import edu.br.unifacear.webdev2019.checkin.repository.BagagemRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;

@Service
public class BagagemService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired	
	private BagagemRepository bagagemrepository;

	public List <Bagagem> findAll(){
		try {
			return bagagemrepository.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Bagagem findOne(Long id){
		try {
			Bagagem bagagem = Optional.
					ofNullable(bagagemrepository.findById(id)).orElse(null).
					orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR500));
			return bagagem;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Bagagem inserirBagagem(Bagagem bagagem) {
		if(bagagem.getPesoBagagem()>23.0) {
			bagagem.setExcesso(true);
			bagagem.setValortotal((bagagem.getValorbagagem()+(bagagem.getPesoBagagem()-23.0)*
					bagagem.getValorexcesso()));
			try {
				Bagagem bagagem2 = Optional.
						ofNullable(bagagemrepository.save(bagagem)).
						orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR501));
				return bagagem2;
			}
			catch (BusinessException ex){
				return null;
			}
		}
		else {
			bagagem.setExcesso(false);
			bagagem.setValortotal(bagagem.getValorbagagem());
			try {
				Bagagem bagagem2 = Optional.
						ofNullable(bagagemrepository.save(bagagem)).
						orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR501));
				return bagagem2;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public Bagagem alterarBagagem(Bagagem bagagem) {
		if(bagagem.getPesoBagagem()>23.0) {
			bagagem.setExcesso(true);
			bagagem.setValortotal((bagagem.getValorbagagem()+(bagagem.getPesoBagagem()-23.0)*
					bagagem.getValorexcesso()));
			try {
				Bagagem bagagem2 = Optional.
						ofNullable(bagagemrepository.save(bagagem)).
						orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR502));
				return bagagem2;
			}
			catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
		else {
			bagagem.setExcesso(false);
			bagagem.setValortotal(bagagem.getValorbagagem());
			try {
				Bagagem bagagem2 = Optional.
						ofNullable(bagagemrepository.save(bagagem)).
						orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR502));
				return bagagem2;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public void deletarBagagem(Bagagem bagagem) {
		try {
			bagagemrepository.delete(bagagem);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
