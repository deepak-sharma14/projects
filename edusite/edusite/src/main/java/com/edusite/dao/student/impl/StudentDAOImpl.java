package com.edusite.dao.student.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edusite.dao.StudentRepository;
import com.edusite.entity.Subject;
@Repository
public abstract class StudentDAOImpl implements StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Optional<List<Subject>> getSubject(int admissionNumber) {
		
			Session session = sessionFactory.getCurrentSession();
	
			
			Criteria criteria = session.createCriteria(Subject.class);
			
			Criterion cr = Restrictions.eq("adimissionNumber", admissionNumber);
			
			criteria.add(cr);
			
			Optional<List<Subject>> subjects =  Optional.of(criteria.list());
			
			sessionFactory.close();
			
			return subjects;
	}

}
