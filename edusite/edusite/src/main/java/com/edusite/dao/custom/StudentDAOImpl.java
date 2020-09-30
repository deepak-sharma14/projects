package com.edusite.dao.custom;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.edusite.entity.Subject;

@Repository
@Component
public class StudentDAOImpl implements StudentCustomDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<List<Subject>> getBySubject(int admissionNumber) {
		
	
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
		Root<Subject> subjectRoot = criteriaQuery.from(Subject.class);
		
		Predicate predicateForAdmissionNumber
		  = criteriaBuilder.equal(subjectRoot.get("admissionNumber"), admissionNumber);
		
		criteriaQuery.where(predicateForAdmissionNumber);
		return  Optional.of(entityManager.createQuery(criteriaQuery).getResultList());
		
//			Criteria criteria = session.createCriteria(Subject.class);
//			
//			Criterion cr = Restrictions.eq("adimissionNumber", admissionNumber);
//			
//			criteria.add(cr);
//			
//			Optional<List<Subject>> subjects =  Optional.of(criteria.list());
//			
//			
		
	}

}
