package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.repository.CancelaRepository;
import edu.br.unifacear.webdev2019.remarcacao.service.exceptions.ObjectNotFoundException;

@Service
public class CancelaService {
	
	@Autowired
	private CancelaRepository repo;
	
	public List<Cancela> find(){
		 return repo.findAll();
	}
	
	public Cancela findById(Long guidCancela) {
		Optional<Cancela> obj = repo.findById(guidCancela);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+guidCancela));
	}
		
	public Cancela save(Cancela obj) {
		return repo.save(obj);
	}
	
	public void delete(Long guidCancela) {
		findById(guidCancela);
		try {
			repo.deleteById(guidCancela);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
