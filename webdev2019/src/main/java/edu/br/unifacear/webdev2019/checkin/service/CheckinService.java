package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.Calendar;
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
		catch(BusinessException e) {
			throw new BusinessException(BusinessExceptionCode.ERR000);
		}
	}
	
	public Checkin findOne(Long id) {
		  Checkin checkin = Optional.ofNullable(checkinRepository.findById(id)).
		  orElse(null).orElseThrow(() -> new
		  BusinessException(BusinessExceptionCode.ERR503)); 
		  return checkin;
	}
	
	public Checkin insertCheckin(Checkin checkin) {
		if(checkin.getDataCheckin().before(Calendar.
				getInstance().getTime())) {
			throw new BusinessException(BusinessExceptionCode.ERR500);
		}
		else if(checkin.getGuidUsuario() == null){
			throw new BusinessException(BusinessExceptionCode.ERR500);
		}
		else if(checkin.getGuidAeronave() == null) {
			throw new BusinessException(BusinessExceptionCode.ERR001);	
		}
		else if(checkin.getGuidVoo() == null) {
			throw new BusinessException(BusinessExceptionCode.ERR500);
		}
		else if(checkin.getGuidPassagem() == null) {
			throw new BusinessException(BusinessExceptionCode.ERR000);
		}
		else {
			return checkinRepository.save(checkin);
		}
	}
	
	public Checkin alterCheckin(Checkin checkin) {
		if(checkin.getDataCheckin().
				before(Calendar.getInstance().getTime())) {
			throw new BusinessException(BusinessExceptionCode.ERR503);
		}
		else {
			return checkinRepository.save(checkin);
		}
	}
	
	public void deleteCheckin(Checkin checkin) {
		try {
			checkinRepository.delete(checkin);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Checkin chekinWithToken(String token) {
		return checkinRepository.findByToken(token);
	}
	
}
