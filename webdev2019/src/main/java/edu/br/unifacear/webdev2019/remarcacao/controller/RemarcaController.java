package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.remarcacao.entity.Remarca;
import edu.br.unifacear.webdev2019.remarcacao.service.RemarcaService;

@RestController
@RequestMapping("/remarca")
public class RemarcaController {
		
		@Autowired
		private RemarcaService service;
		
		@GetMapping
		public List<Remarca> listar(){
			return service.find();
		}
		
		@GetMapping("/{guidRemarca}")
		public ResponseEntity<Remarca> listarPorId(@PathVariable Long guidRemarca) {
			Remarca obj = service.findById(guidRemarca);
			return ResponseEntity.ok().body(obj);
		}
		
		@PostMapping
		public Remarca salvar(@RequestBody Remarca obj) {
			return service.save(obj);
		}
		
		@DeleteMapping(value = "/{guidRemarca}")
		public ResponseEntity<Void> excluir(@PathVariable Long guidRemarca) {
			service.delete(guidRemarca);
			return ResponseEntity.noContent().build();
		}
		
		
}
