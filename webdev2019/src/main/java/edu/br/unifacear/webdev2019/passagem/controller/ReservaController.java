package edu.br.unifacear.webdev2019.passagem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;
	
	@PostMapping
	public void salvar(@RequestBody @Valid Reserva reserva) {
		reservaService.salvar(reserva);
	}
	
	@GetMapping("/list")
	public List<Reserva> listar() {
		return reservaService.listar();
	}
	@GetMapping("/usuario/{guidUsuario}")
	public List<Reserva> listarPorUsuario(@PathVariable (name = "guidUsuario") Long guidUsuario) {
		return reservaService.listarPorUsuario(guidUsuario);
	}
	
	@GetMapping("/{guidReserva}")
	public Reserva buscarPorId(@PathVariable(name = "guidReserva") Long guidReserva) {
		return reservaService.buscarPorId(guidReserva);
		
	}
}
