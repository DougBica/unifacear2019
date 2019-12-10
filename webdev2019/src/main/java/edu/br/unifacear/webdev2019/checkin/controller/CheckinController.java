package edu.br.unifacear.webdev2019.checkin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.checkin.service.CheckinService;

@RestController
@RequestMapping(value="/scp/private/checkin")
@CrossOrigin("*")
public class CheckinController {
	
	@Autowired
	private CheckinService checkinService;
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@GetMapping
	public List<Checkin> listCheckin() {
		return checkinService.findAll();
	}
	
	@PreAuthorize("hasRole('GERENCIAR_SEGUNDO_CHECKIN')")
	@GetMapping(value="/{id}")
	public Checkin listOneCheckin(@PathVariable Long id) {
		return checkinService.findOne(id);
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@PostMapping
	public void insertCheckin(@RequestBody Checkin checkin) {
		checkinService.insertCheckin(checkin);
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@PatchMapping(value="/alter")
	public void alterCheckin(@RequestBody Checkin checkin) {
		checkinService.alterCheckin(checkin);
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@DeleteMapping(value="/delete")
	public void deleteCheckin(@RequestBody Checkin checkin) {
		checkinService.deleteCheckin(checkin);
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@GetMapping(value="/token/{token}")
	public Checkin acharToken(@PathVariable String token) {
		return checkinService.puxarToken(token);
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@GetMapping(value="/listarAberto")
	public List<Checkin> listarAbertos() {
		return checkinService.listarAbertos();
	}
	
	@PreAuthorize("hasRole('GERENCIAR_PRIMEIRO_CHECKIN')")
	@GetMapping(value="/passagem/{id}")
	public Checkin findByPassagem(@PathVariable Long id) {
		return checkinService.listarPorPassagem(id);
	}
	
	@GetMapping(value="/passageiro/{id}")
	public List<Checkin> findByPassageiro(@PathVariable Long id) {
		return checkinService.listarPorPassageiro(id);
	}
	
}
