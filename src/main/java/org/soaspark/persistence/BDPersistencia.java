package org.soaspark.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public enum BDPersistencia {
	BANCO1("pg-PU"),
	BANCO2("oracle-PU");
	
	private String persistenceUnitName;
	
	private BDPersistencia(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}
}
