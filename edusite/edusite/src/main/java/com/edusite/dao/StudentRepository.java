package com.edusite.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
