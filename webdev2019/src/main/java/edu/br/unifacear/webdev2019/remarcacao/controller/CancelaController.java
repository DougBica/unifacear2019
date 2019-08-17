package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Cancela> find(){
		return service.find();
	}
	
	@PostMapping
	public Cancela save(@RequestBody Cancela obj) {
		return service.save(obj);
	}
	
	@RequestMapping(value = "/date",method = RequestMethod.GET)
	public List<Cancela> findByDate(
			@RequestParam(value="DateInit") Date init,
			@RequestParam(value="DateEnd") Date end){
		return service.findByDate(init, end);
	}
	
}
