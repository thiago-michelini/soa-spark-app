package org.soaspark.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public enum BDPersistence {
//	BD_PG("pg-PU"),
	BD_HSQL("hsql-PU");
	
	private EntityManager entityManager;
	
	private BDPersistence(String persistenceUnitName) {
		entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
