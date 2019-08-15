package edu.br.unifacear.webdev2019.compraPassagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.compraPassagem.entity.Passagem;
import edu.br.unifacear.webdev2019.compraPassagem.service.PassagemService;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

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
}
