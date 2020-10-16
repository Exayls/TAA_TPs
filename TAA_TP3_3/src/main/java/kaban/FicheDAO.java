package kaban;

import javax.persistence.EntityManager;

import servlet.EntityManagerHelper;

public class FicheDAO {
	
	
	private EntityManager manager;

	public FicheDAO() {
		this.manager = EntityManagerHelper.getEntityManager();
	}
	
	
	
}
