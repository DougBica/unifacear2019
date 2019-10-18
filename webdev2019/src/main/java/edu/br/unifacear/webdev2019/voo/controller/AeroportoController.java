package edu.br.unifacear.webdev2019.voo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.voo.entity.Aeroporto;
import edu.br.unifacear.webdev2019.voo.service.AeroportoService;

@RestController
@RequestMapping("/aeroporto")
public class AeroportoController {
	@Autowired
	private AeroportoService aeroportoService;

	@PostMapping

	public void salvar(@RequestBody Aeroporto aeroporto) {
		aeroportoService.salvar(aeroporto);

	}

	@GetMapping
	public List<Aeroporto> listar() {

		return aeroportoService.listar();

	}

	@GetMapping("/{guidAeroporto}")
	public Aeroporto buscarPorId(@PathVariable(name = "guidAeroporto") Long guidAeroporto) {

		return aeroportoService.burcarPorId(guidAeroporto);

	}

}
