package kaban;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import servlet.EntityManagerHelper;

public class TableauDAO {
	
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
