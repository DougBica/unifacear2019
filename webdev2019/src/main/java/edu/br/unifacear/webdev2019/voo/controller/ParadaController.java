package edu.br.unifacear.webdev2019.voo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.voo.entity.Parada;
import edu.br.unifacear.webdev2019.voo.service.ParadaService;


@RestController
@RequestMapping("/parada")
public class ParadaController {
	@Autowired
	private ParadaService paradaService;

	@PostMapping
	public void salvar(@RequestBody Parada parada) {
		paradaService.salvar(parada);
	}

	@GetMapping
	public List<Parada> listar() {	
		return paradaService.listar();
	}

	@GetMapping("/{guidParada}")
	public Parada buscarPorId(@PathVariable(name = "guidParada") Long guidParada) {
		return paradaService.burcarPorId(guidParada);
	}

}

