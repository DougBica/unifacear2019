package edu.br.unifacear.webdev2019.passagem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.passagem.dto.PassagensUsuario;
import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.passagem.service.PassagemService;

@RestController
@RequestMapping("/scp/")
@CrossOrigin
public class PassagemController {
	@Autowired
	private PassagemService passagemService;
	
	@PostMapping("public/passagem")
	public void salvar(@RequestBody @Valid Passagem passagem) {
		passagemService.salvar(passagem);	
	}
	
	@PostMapping("private/passagem/reserva")
	public void salvarEmLote(@RequestBody PassagensUsuario listaPassagem) {
		passagemService.salvarEmLote(listaPassagem);	
	}
	
	@GetMapping("public/passagem")
	public List<Passagem> listar() {
	
		return passagemService.listar();
	
	}
	
//	@GetMapping("public/passagem/reserva/{guidReserva}")
//	public List<Passagem> listarPorReserva(@PathVariable(name = "guidReserva") Long guidReserva) {
//		return passagemService.listarPorReserva(guidReserva);
//	}
	
	@GetMapping("public/passagem/{guidPassagem}")
	public Passagem buscarPorId(@PathVariable(name = "guidPassagem") Long guidPassagem) {
		
		return passagemService.burcarPorId(guidPassagem);
	
	}
	
	@GetMapping(value="public/passagem/teste/{id}")
	public Optional<Passagem> oBraboTemNome(@PathVariable Long id) {
		return passagemService.getById(id);
	}

}
