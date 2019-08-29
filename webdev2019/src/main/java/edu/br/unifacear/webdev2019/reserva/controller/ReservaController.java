package edu.br.unifacear.webdev2019.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.reserva.entity.Reserva;
import edu.br.unifacear.webdev2019.reserva.service.ReservaService;

@RestController
@RequestMapping("/passagem")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;
	
	@PostMapping
	public void salvar(@RequestBody Reserva reserva) {
		reservaService.salvar(reserva);
	}
	
	@GetMapping
	public List<Reserva> listar() {
		return reservaService.listar();
	}
	
	@GetMapping("/{guidPassagem}")
	public Reserva buscarPorId(@PathVariable(name = "guidReserva") Long guidReserva) {
		return reservaService.buscarPorId(guidReserva);
		
	}
}
