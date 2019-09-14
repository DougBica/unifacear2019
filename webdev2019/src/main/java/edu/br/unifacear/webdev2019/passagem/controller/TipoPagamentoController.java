package edu.br.unifacear.webdev2019.passagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.passagem.entity.Reserva;
import edu.br.unifacear.webdev2019.passagem.entity.TipoPagamento;
import edu.br.unifacear.webdev2019.passagem.service.TipoPagamentoService;

@RestController
@RequestMapping("/tipoPagamento")
public class TipoPagamentoController {

	@Autowired
	private TipoPagamentoService tipoPagamentoService;
	
	@PostMapping
	public void salvar(@RequestBody TipoPagamento tipoPagamento) {
		tipoPagamentoService.salvar(tipoPagamento);
	}
	
	@GetMapping
	public List<TipoPagamento> listar() {
		return tipoPagamentoService.listar();
	}
	
	@GetMapping("/{guidTipoPagamento}")
	public TipoPagamento buscarPorId(@PathVariable(name = "guidTipoPagamento") Long guidTipoPagamento) {
		return tipoPagamentoService.buscarPorId(guidTipoPagamento);
		
	}
	
}
