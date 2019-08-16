package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.service.CancelaService;

@RestController
@RequestMapping("/cancela")
public class CancelaController {
	
	@Autowired
	private CancelaService service;
	
	@GetMapping
	public List<Cancela> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Cancela save(@RequestBody Cancela obj) {
		return service.save(obj);
	}
	
}
