package fr.istic.taa.jaxrs.dao.generic;

import javax.persistence.EntityManager;



public class FicheDAO {
	
	
	private EntityManager manager;

	public FicheDAO() {
		this.manager = EntityManagerHelper.getEntityManager();
	}
	
	
	
}
