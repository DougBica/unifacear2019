package edu.br.unifacear.webdev2019.checkin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.checkin.entity.Embarque;
import edu.br.unifacear.webdev2019.checkin.service.EmbarqueService;

@RestController
@RequestMapping(value="/scp/public/embarque")
public class EmbarqueController {
	
	@Autowired
	EmbarqueService embarqueService;
	
	@GetMapping
	public List<Embarque> listarTodos(){
		return embarqueService.listarAll();
	}
	
	@GetMapping(value="/{id}")
	public Embarque listarUm(@PathVariable Long id) {
		return embarqueService.listarOne(id);
	}
	
	@PostMapping
	public Embarque inserirEmbarque(@RequestBody Embarque embarque) {
		return embarqueService.inserirEmbarque(embarque);
	}
	
	@PatchMapping
	public Embarque atualizarEmbarque(@RequestBody Embarque embarque) {
		return embarqueService.alterarEmbarque(embarque);
	}
	
	@DeleteMapping
	public void deletarEmbarque(@RequestBody Embarque embarque) {
		embarqueService.deletarEmbarque(embarque);
	}
	
}
