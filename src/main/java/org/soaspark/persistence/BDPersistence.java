package org.soaspark.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum BDPersistence {
//	BD_PG("pg-PU"),
	BD_HSQL("hsql-PU");
	
	private EntityManagerFactory entityManagerFactory;
	private String persistenceUnitName;
	
	private BDPersistence(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}
	
	public EntityManager getEntityManager() {
		if (null == entityManagerFactory)
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		return entityManagerFactory.createEntityManager();
	}
}
