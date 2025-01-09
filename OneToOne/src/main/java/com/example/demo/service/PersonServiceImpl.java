package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Person;
import com.example.demo.repository.PassportRepo;
import com.example.demo.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo   prepo;
	
	@Autowired
	PassportRepo     passRepo;
	
	@Override
	public void addPerson(Person person) {
		 prepo.save(person);
		
	}

	@Override
	public void addPassport(int id, Passport passport) {
		 Person person= prepo.findById(id).get();
		 
		 passport.setPerson(person);
		 
		 passRepo.save(passport);
		
	}

	@Override
	public Passport getPassportForPerson(int id) {
		Person p=prepo.findById(id).get();
		
	     // Passport pass= passRepo.findById(id).get();
	        Passport passs=p.getPassport();
	      return passs;
		
	}
	
	

}
