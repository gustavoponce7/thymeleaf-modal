package com.example.thymeleafpoc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.thymeleafpoc.model.Student;
import com.example.thymeleafpoc.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ThymeleafPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafPocApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(StudentService studentService) {
		return (args) -> {
			log.info("Init App");
			studentService.saveStudent(Student.builder().name("Gustavo").lastName("Ponce").build());
			studentService.saveStudent(Student.builder().name("John").lastName("Smith").build());
			studentService.saveStudent(Student.builder().name("Peter").lastName("Punk").build());
			studentService.saveStudent(Student.builder().name("Bob").lastName("Marley").build());
			studentService.saveStudent(Student.builder().name("David").lastName("Gilmour").build());
			
			for (Student student : studentService.getAllStudents()) {
				log.info(student.getId() + " " + student.getName() + " " + student.getLastName());
			}
		};
	}
}
