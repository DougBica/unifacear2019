package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.checkin.repository.CheckinRepository;
import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;

@Service
public class CheckinService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CheckinRepository checkinRepository;
	
	public List<Checkin> findAll() {
		try {
			return checkinRepository.findAll();		
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Checkin findOne(Long id) {
		Checkin checkin = Optional.ofNullable(checkinRepository.findById(id)).
				orElse(null).orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR503));
		return checkin;
	}
	
	public Checkin insertCheckin(Checkin checkin) {
		Checkin checkin2 = Optional.ofNullable(checkinRepository.save(checkin)).
				orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR504));
		return checkin2;
	}
	
	public Checkin alterCheckin(Checkin checkin) {
		Checkin checkin2 = Optional.
			ofNullable(checkinRepository.save(checkin)).
			orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR505));
		return checkin2;
	}
	
	public void deleteCheckin(Checkin checkin) {
		try {
			checkinRepository.delete(checkin);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
