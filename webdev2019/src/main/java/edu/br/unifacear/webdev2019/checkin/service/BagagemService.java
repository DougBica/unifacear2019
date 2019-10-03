/*package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.Bagagem;
import edu.br.unifacear.webdev2019.checkin.repository.BagagemRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;

@Service
public class BagagemService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Value("${webdev2019.bagagem.peso}")
	private Double peso;

	@Autowired	
	private BagagemRepository bagagemrepository;

	public List <Bagagem> findAll(){
		try {
			return bagagemrepository.findAll();
		}
		catch (BusinessException e) {
			throw new BusinessException(BusinessExceptionCode.ERR000);
		}
	}
	
	public Bagagem findOne(Long id){
		Bagagem bagagem = Optional.
			ofNullable(bagagemrepository.findById(id)).orElse(null).
			orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR500));
		return bagagem;
	}
	
	public Bagagem inserirBagagem(Bagagem bagagem) {
		if(bagagem.getPesoBagagem()>peso) {
			bagagem.setExcesso(true);
			bagagem.setValortotal((bagagem.getValorbagagem()+(bagagem.getPesoBagagem()-peso)*
					bagagem.getValorexcesso()));
			if(bagagem.getGuidCheckin() == null) {
				throw new BusinessException(BusinessExceptionCode.ERR511);
			}
			else {
				return bagagemrepository.save(bagagem);		
			}
		}
		else if(bagagem.getGuidCheckin() == null) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else {
			bagagem.setExcesso(false);
			bagagem.setValortotal(bagagem.getValorbagagem());
			return bagagemrepository.save(bagagem);
		}
	}
	
	public Bagagem alterarBagagem(Bagagem bagagem) {
		if(bagagem.getPesoBagagem()>peso) {
			bagagem.setExcesso(true);
			bagagem.setValortotal((bagagem.getValorbagagem()+(bagagem.getPesoBagagem()-peso)*
					bagagem.getValorexcesso()));
			if(bagagem.getGuidCheckin() == null) {
				throw new BusinessException(BusinessExceptionCode.ERR511);
			}
			else {
				return bagagemrepository.save(bagagem);		
			}
		}
		else if(bagagem.getGuidCheckin() == null) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else {
			bagagem.setExcesso(false);
			bagagem.setValortotal(bagagem.getValorbagagem());
			return bagagemrepository.save(bagagem);
		}
	}
	
	public void deletarBagagem(Bagagem bagagem) {
		try {
			bagagemrepository.delete(bagagem);
		}
		catch(Exception e) {
			throw new BusinessException(BusinessExceptionCode.ERR000);
		}
	}

}
*/