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

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;
import edu.br.unifacear.webdev2019.checkin.service.CheckinService;

@RestController
@RequestMapping(value="/checkin")
public class CheckinController {
	
	@Autowired
	private CheckinService checkinService;
	
	@GetMapping
	public List<Checkin> listCheckin() {
		return checkinService.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Checkin listOneCheckin(@PathVariable Long id) {
		return checkinService.findOne(id);
	}
	
	@PostMapping
	public void insertCheckin(@RequestBody Checkin checkin) {
		checkinService.insertCheckin(checkin);
	}
	
	@PatchMapping(value="/alter")
	public void alterCheckin(@RequestBody Checkin checkin) {
		checkinService.alterCheckin(checkin);
	}
	
	@DeleteMapping(value="/delete")
	public void deleteCheckin(@RequestBody Checkin checkin) {
		checkinService.deleteCheckin(checkin);
	}
	
	@GetMapping(value="/token/{token}")
	public Checkin acharToken(@PathVariable String token) {
		return checkinService.chekinWithToken(token);
	}
	
}
