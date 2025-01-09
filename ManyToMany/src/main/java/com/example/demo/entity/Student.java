package com.example.demo.entity;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int sId;
	 private String name;
	 
	 @ManyToMany(mappedBy = "students")          // mappedBy refers to the "students" field in Teacher
	 @JsonIgnore
	 private Set<Teacher> teachers;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	// Alter+s
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, sId, teachers);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		return Objects.equals(name, other.name) && sId == other.sId && Objects.equals(teachers, other.teachers);
//	}
	
	// ChatGTP
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(sId, student.sId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(sId);
//    }
}





