package com.edusite.dao.custom;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.edusite.entity.Subject;

@Repository
public interface StudentCustomDAO {
	
	Optional<List<Subject>> getBySubject(int admissionNumber);
}
