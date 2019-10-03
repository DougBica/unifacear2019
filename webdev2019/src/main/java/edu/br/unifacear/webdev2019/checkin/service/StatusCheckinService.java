package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.StatusCheckin;
import edu.br.unifacear.webdev2019.checkin.repository.StatusCheckinRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;

@Service
public class StatusCheckinService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private StatusCheckinRepository statuscheckinrepository;

	public List<StatusCheckin> findAll (){

		try {
			return statuscheckinrepository.findAll();
		}
		catch(BusinessException e){
			throw new BusinessException(BusinessExceptionCode.ERR504);
		}

	}

	public StatusCheckin findOne (Long id) {
		StatusCheckin statuscheckin = Optional.ofNullable(statuscheckinrepository.findById(id)).
				orElse(null).orElseThrow(() -> new
						BusinessException(BusinessExceptionCode.ERR504)); 
		return statuscheckin;
	}

	public StatusCheckin insertStatusCheckin(StatusCheckin statuscheckin) {
		if(statuscheckin.getNomeStatus().equals(null)) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else if(statuscheckin.getCorStatus().equals(null)) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else {
			return statuscheckinrepository.save(statuscheckin);		
		}
	}

	public StatusCheckin alterStatusCheckin(StatusCheckin statuscheckin) {
		if(statuscheckin.getNomeStatus().equals(null)) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else if(statuscheckin.getCorStatus().equals(null)) {
			throw new BusinessException(BusinessExceptionCode.ERR511);
		}
		else {
			return statuscheckinrepository.save(statuscheckin);		
		}
	}

	public void deleteStatusCheckin(StatusCheckin statuscheckin) {
		try {
			statuscheckinrepository.delete(statuscheckin);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
