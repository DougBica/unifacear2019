package edu.br.unifacear.webdev2019.aeronave.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.entity.Fabricante;
import edu.br.unifacear.webdev2019.aeronave.service.FabricanteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody Fabricante fabricante) {
		fabricanteService.salvar(fabricante);
	}

	@GetMapping("/listar")
	public List<Fabricante> listar() {
		return fabricanteService.listar();
	}
	
	@GetMapping("/buscarPorId/{guidFabricante}")
	public Fabricante findOneById(@PathVariable("guidFabricante") Long guidFabricante) {
		return fabricanteService.findOneById(guidFabricante);
	}

}
