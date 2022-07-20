package com.edusite.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Syllabus;

public interface SyllabusRepository extends JpaRepository<Syllabus, Integer>{
	
	public Optional<Syllabus> findBySubjectName(String subjectName);
	

}
