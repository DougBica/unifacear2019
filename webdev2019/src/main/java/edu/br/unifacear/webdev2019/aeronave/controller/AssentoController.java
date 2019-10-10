package edu.br.unifacear.webdev2019.aeronave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.aeronave.entity.Assento;
import edu.br.unifacear.webdev2019.aeronave.service.AssentoService;

@RestController
@RequestMapping("/assento")
public class AssentoController {

	@Autowired
	private AssentoService assentoService;

	@PostMapping
	public void salvar(@RequestBody Assento assento) {
		assentoService.salvar(assento);
	}

	@GetMapping
	public List<Assento> listar() {
		return assentoService.listar();
	}
	
	@GetMapping("/{guidAssento}")
	public Assento findOneById(@PathVariable("guidAssento") Long guidAssento) {
		return assentoService.findOneById(guidAssento);
	}
	
	@GetMapping("/aeronave/{guidAeronave}")
	public List<Assento> findAllByGuidAeronave(@PathVariable("guidAeronave") Long guidAeronave) {
		return assentoService.findAllByGuidAeronave(guidAeronave);
	}


}
