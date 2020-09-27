package com.edusite.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Student;
import com.edusite.entity.Subject;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<List<Subject>> getSubject(int admissionNumber);
	
}
