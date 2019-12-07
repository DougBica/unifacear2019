package edu.br.unifacear.webdev2019.aeronave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.aeronave.entity.Aeronave;
import edu.br.unifacear.webdev2019.aeronave.service.AeronaveService;

@CrossOrigin("*")
@RestController
@RequestMapping("/scp/private/aeronave")
public class AeronaveController {

	@Autowired
	private AeronaveService aeronaveService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody Aeronave aeronave) {
		aeronaveService.salvar(aeronave);
	}

	@GetMapping("/listar")
	public List<Aeronave> listar() {
		return aeronaveService.listar();
	}
	
	@GetMapping("/buscarPorId/{guidAeronave}")
	public Aeronave BuscarPorID(@PathVariable("guidAeronave") Long guidAeronave) {
		return aeronaveService.findOneById(guidAeronave);
	}
	
	@DeleteMapping("/remover/{guidAeronave}")
	public void remover(@PathVariable("guidAeronave") Long guidAeronave) {
		aeronaveService.remover(guidAeronave);
	}

}
