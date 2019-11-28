package edu.br.unifacear.webdev2019.voo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.voo.entity.Rota;
import edu.br.unifacear.webdev2019.voo.service.RotaService;


@RestController
@RequestMapping("/scp/public/rota")
public class RotaController {
	@Autowired
	private RotaService rotaService;
	
	@PostMapping
	public void salvar(@RequestBody Rota rota) {
		rotaService.salvar(rota);
	}
	
	@GetMapping
	public List<Rota> listar() {
		return rotaService.listar();
	}
	
	@GetMapping("/{guidRota}")
	public Rota buscarPorId(@PathVariable(name = "guidRota") Long guidRota) {

		return rotaService.burcarPorId(guidRota);

	}

}
