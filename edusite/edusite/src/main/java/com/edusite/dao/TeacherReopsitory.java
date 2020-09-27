package com.edusite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Student;
import com.edusite.entity.Teacher;

public interface TeacherReopsitory extends JpaRepository<Teacher, Integer>{

	Optional<List<Student>> getStudent(int employeeId);

	
}
