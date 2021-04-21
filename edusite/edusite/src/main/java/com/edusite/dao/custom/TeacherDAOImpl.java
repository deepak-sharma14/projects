package com.edusite.dao.custom;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.edusite.entity.Student;
import com.edusite.entity.Batch;
@Repository
@Component

public class TeacherDAOImpl implements TeacherCustomDAO  {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Optional<List<Student>> getByStudent(String batch) {
		
		Optional<List<Student>> students = null;
		
		Session session = entityManager.unwrap(Session.class);
		
			Criteria criteriaStudent = session.createCriteria(Student.class);
		
				Criterion studentCriterion = Restrictions.eq("batch", batch);
				
				criteriaStudent.add(studentCriterion);
			
			 students = Optional.of(criteriaStudent.list()); 
		
		
		return students;
	}

}
