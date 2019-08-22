package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.service.CancelaService;

@RestController
@RequestMapping("/cancela")
public class CancelaController {
	
	@Autowired
	private CancelaService service;
	
	@GetMapping
	public List<Cancela> listar(){
		return service.find();
	}
	
	@RequestMapping(value = "/{guidCancela}", method = RequestMethod.GET)
	public ResponseEntity<Cancela> listarPorId(Long guidCancela) {
		Cancela obj = service.findById(guidCancela);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public Cancela salvar(@RequestBody Cancela obj) {
		return service.save(obj);
	}
	
	@RequestMapping(value = "/{guidCancela}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long guidCancela) {
		service.delete(guidCancela);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/date",method = RequestMethod.GET)
	public List<Cancela> findByDate(
			@RequestParam(value="Init") Date init,
			@RequestParam(value="End") Date end){
		return service.findByDate(init, end);
	}
	
}
