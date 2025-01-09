package com.example.demo.service;

import java.util.Set;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;

public interface SchoolService {
	
	
	 public void addStudent(Student student);
	 public void addTeacher(Teacher teacher);
	 public  void assignStudentToTeacher(int sid, int tid);
	public Set<Student> findStudentsByTeacherId(int tid);
	public Set<Teacher> findTeachersByStudentId(int sid);

}
