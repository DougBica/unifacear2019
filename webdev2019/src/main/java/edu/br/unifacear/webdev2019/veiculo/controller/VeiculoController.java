package edu.br.unifacear.webdev2019.veiculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.veiculo.entity.Veiculo;
import edu.br.unifacear.webdev2019.veiculo.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Veiculo veiculo) {
		veiculoService.salvar(veiculo);
	}
	
	@GetMapping("/listar")
	public List<Veiculo> listar() {
		return veiculoService.listar();
	}

	@GetMapping("/BuscarPorID")
	public Veiculo BuscarPorID(final Long guidVeiculo) {
		return veiculoService.buscarPorId(guidVeiculo);
	}

}
