package com.example.demo.entity;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String name;
	
	@ManyToMany
	@JoinTable(name="teacher_student",
	joinColumns=@JoinColumn(name="teache_id"),
	inverseJoinColumns= @JoinColumn(name="student_id"))
	@JsonIgnore
	private Set<Student> students;
	
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	// alter+s
//	@Override
//	public int hashCode() {
//		return Objects.hash( tId);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Teacher other = (Teacher) obj;
//		return Objects.equals(name, other.name) && Objects.equals(students, other.students) && tId == other.tId;
//	}
	
	
	//ChatGTP
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Teacher course = (Teacher) o;
//        return Objects.equals(tId, course.tId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tId);
//    }
}
	


