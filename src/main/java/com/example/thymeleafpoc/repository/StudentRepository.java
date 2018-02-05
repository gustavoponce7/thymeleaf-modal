package com.example.thymeleafpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleafpoc.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
