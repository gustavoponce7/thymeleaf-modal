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

@Controller
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
	
	/*
	 * MODAL DIALOGS
	 * 
	 */
	@GetMapping(value="/student/{id}")
	public String getStudentModal(@PathVariable("id") long id, ModelMap model) {
		Student student = studentService.getOneStudentById(id);
		model.addAttribute("student", student);
		return "modal/student :: student";
	}
	
	@GetMapping(value="/delete-student/{id}")
	public String deleteStudentConfirmation(@PathVariable("id") long id, ModelMap model) {
		Student student = studentService.getOneStudentById(id);
		model.addAttribute("student", student);
		return "modal/delete-student :: delete-student";
	}
	
	@GetMapping(value="/edit-student/{id}")
	public String editStudentModal(@PathVariable("id") long id, ModelMap model) {
		Student student = studentService.getOneStudentById(id);
		model.addAttribute("student", student);
		return "modal/edit-student :: edit-student";
	}
	/*
	 * 
	 * END MODAL DIALOGS
	 */
}
