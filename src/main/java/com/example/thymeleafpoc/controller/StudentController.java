package com.example.thymeleafpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.thymeleafpoc.model.Student;
import com.example.thymeleafpoc.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/students")
	public ModelAndView getStudents() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("students");
		modelAndView.addObject("students", studentService.getAllStudents());
		return modelAndView;
	}
	
	
	@PostMapping(value="/delete-student/{id}")
	public ModelAndView deleteStudent(@PathVariable("id") long id, ModelMap model) {
		Student student = studentService.getOneStudentById(id);
		studentService.deleteStudent(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/students");
		modelAndView.addObject("students", studentService.getAllStudents());
		return modelAndView;
	}
	
	@PostMapping(value="/edit-student")
	public ModelAndView editStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", studentService.getAllStudents());
		modelAndView.setViewName("redirect:/students");
		return modelAndView;
	}
	
	@PostMapping(value="/add-student")
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView();
		studentService.saveStudent(student);
		modelAndView.addObject("students", studentService.getAllStudents());
		modelAndView.setViewName("redirect:/students");
		return modelAndView;
	}
	
}
