package org.soaspark.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum BDPersistence {
//	BD_PG("pg-PU"),
	BD_HSQL("hsql-PU");
	
	private EntityManagerFactory entityManagerFactory;
	
	private BDPersistence(String persistenceUnitName) {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
