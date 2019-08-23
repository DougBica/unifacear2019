package edu.br.unifacear.webdev2019.remarcacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.service.CancelaService;

@RestController
@RequestMapping("/remarca")
public class RemarcaController {
		
		@Autowired
		private CancelaService service;
		
		@GetMapping
		public List<Cancela> listar(){
			return service.find();
		}
		
		@RequestMapping(value = "/{guidRemarca}", method = RequestMethod.GET)
		public ResponseEntity<Cancela> listarPorId(Long guidRemarca) {
			Cancela obj = service.findById(guidRemarca);
			return ResponseEntity.ok().body(obj);
		}
		
		@PostMapping
		public Cancela salvar(@RequestBody Cancela obj) {
			return service.save(obj);
		}
		
		@RequestMapping(value = "/{guidRemarca}",method = RequestMethod.DELETE)
		public ResponseEntity<Void> excluir(@PathVariable Long guidRemarca) {
			service.delete(guidRemarca);
			return ResponseEntity.noContent().build();
		}
}
