package edu.br.unifacear.webdev2019.aeronave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.service.AeronaveService;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

	@Autowired
	private AeronaveService aeronaveService;

	@PostMapping
	public void salvar(@RequestBody Aeronave aeronave) {
		aeronaveService.salvar(aeronave);
	}

	@GetMapping
	public List<Aeronave> listar() {
		return aeronaveService.listar();
	}
	
	@GetMapping("{guidAeronave}")
	public Aeronave findOneById(@PathVariable("guidAeronave") Long guidAeronave) {
		return aeronaveService.findOneById(guidAeronave);
	}
	

}
