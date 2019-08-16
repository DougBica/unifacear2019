package edu.br.unifacear.webdev2019.checkin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.checkin.repository.CheckinRepository;

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
	
	public Optional<Checkin> findOne(Long id) {
		try {
			return checkinRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insertCheckin(Checkin checkin) {
		try {
			checkinRepository.save(checkin);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterCheckin(Checkin checkin) {
		try {
			checkinRepository.save(checkin);
		}
		catch(Exception e) {
			e.printStackTrace();
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
	
}
