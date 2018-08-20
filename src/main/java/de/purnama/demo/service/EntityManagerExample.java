package de.purnama.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import de.purnama.demo.model.UserData;

@Service
public class EntityManagerExample {

	@PersistenceContext
	EntityManager em;
	
	public UserData getUserDataById(Long id){
		return em.find(UserData.class, 1L);
	}
	
	public List<UserData> getAllUserData(){
		em.getTransaction().begin();
		Query query = em.createQuery("select ud from UserData ud");
		List<UserData> resultList = query.getResultList();
		em.getTransaction().commit();
		return resultList;
	}
}
