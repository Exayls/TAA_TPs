package fr.istic.taa.jaxrs.dao.generic;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.istic.taa.jaxrs.domain.Tableau;

public class TableauDAO extends AbstractJpaDao<Integer, Tableau>{
	
	private EntityManager manager;

	public TableauDAO() {
		this.manager = EntityManagerHelper.getEntityManager();
	}
	
	public void saveTableau(Tableau t) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(t);
		tx.commit();
	}
	
	
	public Tableau getFirstTableau(EntityManager manager) {
		Tableau t =  manager.createQuery("Select a From Tableau a", Tableau.class).getResultList().get(0);
		
		return t;
	}
	
	
}
