package com.example.thymeleafpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleafpoc.model.Student;
import com.example.thymeleafpoc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getOneStudentById(long id) {
		return studentRepository.findOne(id);
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
}
