package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	SchoolService  service;
	@PostMapping("/student")
	public ResponseEntity addStudent(@RequestBody Student student) {
		service.addStudent(student);
		return new ResponseEntity("Student Added", HttpStatus.CREATED);
	}
	@PostMapping("/teacher")
	public  ResponseEntity  addTeacher(@RequestBody Teacher teacher) {
		service.addTeacher(teacher);
		return new ResponseEntity("Teacher Added", HttpStatus.CREATED);
		
	}
	@PostMapping("/student/{sid}/teacher/{tid}")
	public  ResponseEntity assignStudentToTeacher(@PathVariable("sid") int sid, @PathVariable("tid") int tid) {
		service.assignStudentToTeacher(sid, tid);
		
		return new ResponseEntity("Assigned... Sucessfully ", HttpStatus.CREATED);
	}
	 @GetMapping("/{sid}/teachers")
	    public  ResponseEntity<Set<Teacher>> findTeachersByStudentId(@PathVariable("sid") int sid) {
	         Set<Teacher> teachers = service.findTeachersByStudentId(sid);
	      return new   ResponseEntity(teachers,HttpStatus.OK);
	    }

	    @GetMapping("/{tid}/students")
	    public  ResponseEntity<Set<Student>> findStudentsByTeacherId(@PathVariable("tid") int tid) {
	        Set<Student> students = service.findStudentsByTeacherId(tid);
	        return new   ResponseEntity(students,HttpStatus.OK);
	    }

}
