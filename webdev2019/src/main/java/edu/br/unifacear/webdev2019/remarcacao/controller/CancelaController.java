package edu.br.unifacear.webdev2019.remarcacao.controller;

<<<<<<< HEAD
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;
import edu.br.unifacear.webdev2019.remarcacao.service.CancelaService;

@RestController
<<<<<<< HEAD
@RequestMapping("/scp/public/cancela")
=======
@RequestMapping("/cancela")
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
public class CancelaController {
	
	@Autowired
	private CancelaService service;
	
	@GetMapping
	public List<Cancela> listar(){
		return service.find();
	}
	
<<<<<<< HEAD
	@GetMapping("/{guidCancela}")
	public ResponseEntity<Cancela> listarPorId(@PathVariable Long guidCancela) {
=======
	@RequestMapping(value = "/{guidCancela}", method = RequestMethod.GET)
	public ResponseEntity<Cancela> listarPorId(Long guidCancela) {
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
		Cancela obj = service.findById(guidCancela);
		return ResponseEntity.ok().body(obj);
	}
	
<<<<<<< HEAD
	@GetMapping("/guidusuario/{guidUsuario}")
	public Cancela findByGuidUsuario(@PathVariable Long guidUsuario) {
		return service.findByGuidUsuario(guidUsuario);
	}
	
	@GetMapping("/guidreserva/{guidReserva}")
	public List<Cancela> findByGuidReserva(@PathVariable Long guidReserva) {
		return service.findByGuidReserva(guidReserva);
	}
	
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
	@PostMapping
	public Cancela salvar(@RequestBody Cancela obj) {
		return service.save(obj);
	}
	
<<<<<<< HEAD
	@PostMapping("/{guidCancela}")
	public Cancela atualizar(@Valid @RequestBody Cancela cancela) {
		return service.update(cancela);
	}
	
	@DeleteMapping("/{guidCancela}")
=======
	@RequestMapping(value = "/{guidCancela}",method = RequestMethod.DELETE)
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
	public ResponseEntity<Void> excluir(@PathVariable Long guidCancela) {
		service.delete(guidCancela);
		return ResponseEntity.noContent().build();
	}
	
<<<<<<< HEAD
}
=======
	@RequestMapping(value = "/date",method = RequestMethod.GET)
	public List<Cancela> findByDate(
			@RequestParam(value="Init") Date init,
			@RequestParam(value="End") Date end){
		return service.findByDate(init, end);
	}
	
}
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
