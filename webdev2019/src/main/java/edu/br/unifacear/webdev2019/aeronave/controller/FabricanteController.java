package edu.br.unifacear.webdev2019.aeronave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.aeronave.entity.Fabricante;
import edu.br.unifacear.webdev2019.aeronave.service.FabricanteService;





	
	
	@RestController
	@RequestMapping("/aeronave")
	public class FabricanteController {

		@Autowired
		private FabricanteService fabricanteService;
		
		@PostMapping
		public void salvar(@RequestBody Fabricante fabricante) {
			fabricanteService.salvar(fabricante);
		}
		
		@GetMapping
		public List<Fabricante> listar() {
			return fabricanteService.listar();
		}
		

	}
	
