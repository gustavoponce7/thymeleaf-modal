package com.example.thymeleafpoc.controller;

import java.time.LocalDate;

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
public class ModalDialogsController {

	@Autowired
	private StudentService studentService;
	
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
	
	@GetMapping(value="/add-student")
	public String addStudentModal(ModelMap model) {
		Student student = new Student();
		student.setBirthday(LocalDate.now());
		model.addAttribute("student", student);
		return "modal/add-student :: add-student";
	}
	/*
	 * 
	 * END MODAL DIALOGS
	 */
}
