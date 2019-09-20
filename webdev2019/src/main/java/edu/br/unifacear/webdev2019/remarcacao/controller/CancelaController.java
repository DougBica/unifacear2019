package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.service.CancelaService;

@RestController
@RequestMapping("/cancela")
public class CancelaController {
	
	@Autowired
	private CancelaService service;
	
	@GetMapping
	public List<Cancela> listar(){
		return service.find();
	}
	
	@GetMapping("/{guidCancela}")
	public ResponseEntity<Cancela> listarPorId(@PathVariable Long guidCancela) {
		Cancela obj = service.findById(guidCancela);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/guidusuario/{guidUsuario}")
	public Cancela findByGuidUsuario(@PathVariable Long guidUsuario) {
		return service.findByGuidUsuario(guidUsuario);
	}
	
	@GetMapping("/guidreserva/{guidReserva}")
	public List<Cancela> findByGuidReserva(@PathVariable Long guidReserva) {
		return service.findByGuidReserva(guidReserva);
	}
	
	@PostMapping
	public Cancela salvar(@RequestBody Cancela obj) {
		return service.save(obj);
	}
	
	@PostMapping("/{guidCancela}")
	public Cancela atualizar(@Valid @RequestBody Cancela cancela) {
		return service.update(cancela);
	}
	
	@DeleteMapping("/{guidCancela}")
	public ResponseEntity<Void> excluir(@PathVariable Long guidCancela) {
		service.delete(guidCancela);
		return ResponseEntity.noContent().build();
	}
	
}