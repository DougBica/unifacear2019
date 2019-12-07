package edu.br.unifacear.webdev2019.passagem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
@RequestMapping("/scp/public/passagem")
public class PassagemController {
	@Autowired
	private PassagemService passagemService;
	
	@PostMapping
	public void salvar(@RequestBody @Valid Passagem passagem) {
		passagemService.salvar(passagem);	
	}
	
	@GetMapping
	public List<Passagem> listar() {
	
		return passagemService.listar();
	
	}
	
	@GetMapping("/reserva/{guidReserva}")
	public List<Passagem> listarPorReserva(@PathVariable(name = "guidReserva") Long guidReserva) {
		return passagemService.listarPorReserva(guidReserva);
	}
	
	@GetMapping("/{guidPassagem}")
	public Passagem buscarPorId(@PathVariable(name = "guidPassagem") Long guidPassagem) {
		
		return passagemService.burcarPorId(guidPassagem);
	
	}
	
	//method passagem by checkin - gabriel
	@GetMapping("/checkin/{id}")
	public Optional<Passagem> findCheckin(@PathVariable Long id) {
		return passagemService.findMyCheckin(id);
	}
	
}
