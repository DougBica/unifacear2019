package edu.br.unifacear.webdev2019.passagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.service.PassagemService;

@RestController
@RequestMapping("/passagem")
public class PassagemController {
	@Autowired
	private PassagemService passagemService;
	
	@PostMapping
	public void salvar(@RequestBody Passagem passagem) {
		passagemService.salvar(passagem);
	}
	
	@GetMapping
	public List<Passagem> listar() {
		return passagemService.listar();
	}
	
	@GetMapping("/{guidPassagem}")
	public Passagem buscarPorId(@PathVariable(name = "guidPassagem") Long guidPassagem) {
		return passagemService.burcarPorId(guidPassagem);
		
	}
}
