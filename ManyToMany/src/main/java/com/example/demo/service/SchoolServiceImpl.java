package com.example.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.TeacherRepo;

@Service
public class SchoolServiceImpl  implements SchoolService{

	@Autowired
	StudentRepo srepo;
	
	@Autowired
	TeacherRepo trepo;
	
	@Override
	public void addStudent(Student student) {
		srepo.save(student);
		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		trepo.save(teacher);
		
	}

	@Override
	public void assignStudentToTeacher(int sid, int tid) {
	Student student=srepo.findById(sid).get();	
	Teacher teacher=trepo.findById(tid).get();
	    
	     student.getTeachers().add(teacher);
	     teacher.getStudents().add(student);
	     
	    srepo.save(student);
	    trepo.save(teacher);
		
		
	     
	}
	
	 public Set<Teacher> findTeachersByStudentId(int sid) {
	        Student student = srepo.findById(sid).get();
	        return student.getTeachers();
	    }

	    public Set<Student> findStudentsByTeacherId(int tid) {
	        Teacher teacher = trepo.findById(tid).get();
	        return teacher.getStudents();
	    }

}
