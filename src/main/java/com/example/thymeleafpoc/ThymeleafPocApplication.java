package com.example.thymeleafpoc;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.thymeleafpoc.enums.StudentType;
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
			studentService.saveStudent(Student.builder().name("Gustavo").lastName("Ponce").birthday(LocalDate.of(1984, Month.OCTOBER, 20)).studentType(StudentType.UNIVERSITY).build());
			studentService.saveStudent(Student.builder().name("John").lastName("Smith").birthday(LocalDate.of(1990, Month.FEBRUARY, 23)).studentType(StudentType.HIGH_SCHOOL).build());
			studentService.saveStudent(Student.builder().name("Peter").lastName("Punk").birthday(LocalDate.of(1700, Month.JANUARY, 1)).studentType(StudentType.HIGH_SCHOOL).build());
			studentService.saveStudent(Student.builder().name("Bob").lastName("Marley").birthday(LocalDate.of(1974, Month.SEPTEMBER, 23)).studentType(StudentType.ELEMENTARY).build());
			studentService.saveStudent(Student.builder().name("David").lastName("Gilmour").birthday(LocalDate.of(1999, Month.MARCH, 5)).studentType(StudentType.HIGH_SCHOOL).build());
			
			for (Student student : studentService.getAllStudents()) {
				log.info(student.getId() + " " + student.getName() + " " + student.getLastName() + " " + student.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/uuuu")) + " " + student.getStudentType().getName());
			}
		};
	}
}
