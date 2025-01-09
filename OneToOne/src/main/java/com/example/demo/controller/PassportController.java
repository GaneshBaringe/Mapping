package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
public class PassportController {
	
	@Autowired
	PersonService   pservice;
	
@PostMapping("/person")
public ResponseEntity addPerson(@RequestBody Person person) {
	
	pservice.addPerson(person);
	return new ResponseEntity("Person Added", HttpStatus.CREATED);
}

@PostMapping("/{id}/passport")
public ResponseEntity addPassport(@PathVariable("id") int id, @RequestBody Passport passport) {
	pservice.addPassport(id, passport);
	return new ResponseEntity("Passport Mapped", HttpStatus.CREATED);
}

@GetMapping("/{id}/passport")
public ResponseEntity getPassportForPerson(@PathVariable("id") int id) {
	Passport p=pservice.getPassportForPerson(id);
	return new ResponseEntity(p, HttpStatus.OK);
}


}
