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

import edu.br.unifacear.webdev2019.checkin.entity.StatusCheckin;
import edu.br.unifacear.webdev2019.checkin.service.StatusCheckinService;

@RestController
@RequestMapping(value="/statuscheckin")
public class StatusController {
	
	@Autowired
	StatusCheckinService statuscheckinservice;
	

	@GetMapping
	public List<StatusCheckin> liststatuscheckin() {
		return statuscheckinservice.findAll();
	}
	
	@GetMapping(value="/{id}")
	public StatusCheckin listOnestatusCheckin(@PathVariable Long id) {
		return statuscheckinservice.findOne(id);
	}
	
	@PostMapping
	public void insertStatusCheckin(@RequestBody StatusCheckin statuscheckin) {
		statuscheckinservice.insertStatusCheckin(statuscheckin);
	}
	
	@PatchMapping(value="/alter")
	public void alterStatusCheckin(@RequestBody StatusCheckin statuscheckin) {
		statuscheckinservice.alterStatusCheckin(statuscheckin);
	}
	
	@DeleteMapping(value="/delete")
	public void deleteStatusCheckin(@RequestBody StatusCheckin statuscheckin) {
		statuscheckinservice.deleteStatusCheckin(statuscheckin);
	}

	

}
