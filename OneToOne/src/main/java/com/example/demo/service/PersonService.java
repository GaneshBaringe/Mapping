package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Passport;
import com.example.demo.entity.Person;

public interface PersonService {
	public void addPerson(Person person);
	public void addPassport(int id, Passport passport);
	public Passport getPassportForPerson(int id);

}
