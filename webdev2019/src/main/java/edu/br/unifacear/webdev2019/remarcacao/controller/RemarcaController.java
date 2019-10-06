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
@RequestMapping("/scp/public/remarca")
public class RemarcaController {
		
		@Autowired
		private RemarcaService service;
		
		@GetMapping
		public ResponseEntity<List<Remarca>> listar(){
			List<Remarca> list = service.find();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping("/{guidRemarca}")
		public ResponseEntity<Remarca> listarPorId(@PathVariable Long guidRemarca) {
			Remarca obj = service.findById(guidRemarca);
			return ResponseEntity.ok().body(obj);
		}
		
		@GetMapping("/guidreserva/{guidReserva}")
		public ResponseEntity<Remarca> findByGuidReserva(@PathVariable Long guidReserva) {
			 Remarca obj = service.findByGuidReserva(guidReserva);
			 return ResponseEntity.ok().body(obj);
		}
		
		@GetMapping("/guidpassagem/{guidPassagem}")
		public ResponseEntity<Remarca> findByGuidPassagem(@PathVariable Long guidPassagem) {
			Remarca obj = service.findByGuidPassagem(guidPassagem);
			return ResponseEntity.ok().body(obj);
		}
		
		@PostMapping
		public ResponseEntity<Void> salvar(@RequestBody Remarca obj) {
			service.save(obj);
			return ResponseEntity.noContent().build();
		}

		@PostMapping("/{guidRemarca}")
		public ResponseEntity<Void> atualizar(@PathVariable @RequestBody Long guidRemarca ){
			service.update(guidRemarca);
			return ResponseEntity.noContent().build();
		}
		
		@DeleteMapping(value = "/{guidRemarca}")
		public ResponseEntity<Void> excluir(@PathVariable Long guidRemarca) {
			service.delete(guidRemarca);
			return ResponseEntity.noContent().build();
		}
}