package com.edusite.dao.custom;
import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.edusite.entity.Subject;
@Repository
@Component

public class StudentDAOImpl implements StudentCustomDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Optional<List<Subject>> getBySubject(int admissionNumber) {
		
			Session session = sessionFactory.getCurrentSession();
	
			
			Criteria criteria = session.createCriteria(Subject.class);
			
			Criterion cr = Restrictions.eq("adimissionNumber", admissionNumber);
			
			criteria.add(cr);
			
			Optional<List<Subject>> subjects =  Optional.of(criteria.list());
			
			sessionFactory.close();
			
			return subjects;
	}

}
