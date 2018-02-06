package com.example.thymeleafpoc.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.thymeleafpoc.enums.StudentType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String lastName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthday;
	private StudentType studentType;
	
}
