package edu.br.unifacear.webdev2019.voo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.voo.entity.Voo;
import edu.br.unifacear.webdev2019.voo.service.VooService;

@RestController
@RequestMapping("/voo")
public class VooController {
	@Autowired
	private VooService vooService;

	@PostMapping
	public void salvar(@RequestBody Voo voo) {
		vooService.salvar(voo);
	}

	@GetMapping
	public List<Voo> listar() {
		return vooService.listar();
	}

	@GetMapping("/{guidVoo}")
	public Voo buscarPorId(@PathVariable(name = "guidVoo") Long guidVoo) {

		return vooService.burcarPorId(guidVoo);

	}

}
