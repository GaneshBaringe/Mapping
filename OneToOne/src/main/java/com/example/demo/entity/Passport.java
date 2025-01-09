package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int pid;
	private String passortNumber;
	private String issueDate;
	private String experyDate;
	
	@OneToOne
	@JoinColumn(name="id")
	@JsonIgnore
	private Person person;

	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPassortNumber() {
		return passortNumber;
	}

	public void setPassortNumber(String passortNumber) {
		this.passortNumber = passortNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExperyDate() {
		return experyDate;
	}

	public void setExperyDate(String experyDate) {
		this.experyDate = experyDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [pid=" + pid + ", passortNumber=" + passortNumber + ", issueDate=" + issueDate
				+ ", experyDate=" + experyDate + ", person=" + person + "]";
	}

	
	
  
}
