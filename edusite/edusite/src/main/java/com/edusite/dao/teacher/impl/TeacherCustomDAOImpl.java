package com.edusite.dao.teacher.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Student;
import com.edusite.entity.TeacherInfo;
@Repository
public abstract class TeacherDAOImpl implements TeacherReopsitory {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Optional<List<Student>> getStudent(int employeeId) {
		
		Optional<List<Student>> students = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteriaBatch = session.createCriteria(TeacherInfo.class);
		
			Projection batchProjection = Projections.property("bacth");
		
			criteriaBatch.setProjection(batchProjection);
		
			Criterion batchCriterion = Restrictions.eq("employeeId", employeeId);
			
			criteriaBatch.add(batchCriterion);
		
		List<String> batches =(List<String>) criteriaBatch.list();
		
		for (String batch : batches) {
			Criteria criteriaStudent = session.createCriteria(Student.class);
		
				Criterion studentCriterion = Restrictions.eq("bacth", batch);
				
			criteriaStudent.add(studentCriterion);
			
			 students = Optional.of(criteriaStudent.list()); 
		
		}
		
		return students;
	}

}
