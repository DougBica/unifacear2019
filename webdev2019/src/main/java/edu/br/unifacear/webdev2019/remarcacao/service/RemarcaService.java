package edu.br.unifacear.webdev2019.remarcacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;
import edu.br.unifacear.webdev2019.remarcacao.repository.RemarcaRepository;


@Service
public class RemarcaService {
	
	@Autowired
	private RemarcaRepository repo;
	
	public List<Remarca> find(){
		return repo.findAll();
	}
	
	/*public Remarca findById(Long guidRemarca) {
		Optional<Remarca> obj = repo.findById(guidRemarca);
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+guidRemarca));
	}*/
	
	public Remarca save(Remarca obj) {
		return repo.save(obj);
	}
	
	public void delete(Long guidRemarca) {
	//	findById(guidRemarca);
		try {
			repo.deleteById(guidRemarca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Remarca update(Remarca obj) {
		//findById(obj.getGuidRemarcar());
		return repo.save(obj);
	}
}
