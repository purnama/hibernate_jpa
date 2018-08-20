package de.purnama.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import de.purnama.demo.model.UserData;

@Service
public class EntityManagerExample {

	@PersistenceContext
	EntityManager em;
	
	public UserData getUserDataById(Long id){
		return em.find(UserData.class, 1L);
	}
	
	public UserData getUserDataByIdWithCriteria(Long id){
		  CriteriaBuilder cb = em.getCriteriaBuilder();
		  CriteriaQuery<UserData> q = cb.createQuery(UserData.class);
		  Root<UserData> root = q.from(UserData.class);
		  q.select(root).where(cb.equal(root.get("id"), id));
		  TypedQuery<UserData> typedQuery = em.createQuery(q.select(root));
		  return typedQuery.getSingleResult();
	}
	
	public List<UserData> getAllUserData(){
		
		Query query = em.createQuery("select ud from UserData ud");
		List<UserData> resultList = query.getResultList();
		
		return resultList;
	}
	
	public List<UserData> getAllUserDataForceEager(){
		Query query = em.createQuery("select ud from UserData ud "
				+ "left join fetch ud.reviewList reviews "
				+ "left join fetch reviews.reviewStatement revStat "
				+ "left join fetch reviews.department dept"
				+ "left join fetch reviews.civilService civServ");
		List<UserData> resultList = query.getResultList();
		return resultList;
	}
	
	public List<UserData> getAllUserDataByCriteria(){
		  CriteriaBuilder cb = em.getCriteriaBuilder();
		  CriteriaQuery<UserData> q = cb.createQuery(UserData.class);
		  Root<UserData> root = q.from(UserData.class);
		  TypedQuery<UserData> typedQuery = em.createQuery(q.select(root));
		  return typedQuery.getResultList();
	}
}
