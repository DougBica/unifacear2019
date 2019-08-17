package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;

@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> find(){
		 return repo.findAll();
	}
	
	public Optional<Cancela> findById(Long id) {
		return repo.findById(id);
	}
		
	public Cancela save(Cancela can) {
		return repo.save(can);
	}
	
	public List<Cancela> findByDate(Date init, Date end){
		List<Cancela> list = find();
		List<Cancela> list_date = new ArrayList<>();
		for(Cancela c: list  ){
			if( c.getDataCancelamento().before(end) && c.getDataCancelamento().after(init) ) {
				list_date.add(c);
			}
		}
		return list_date;
	}

}
