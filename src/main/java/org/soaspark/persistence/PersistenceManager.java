package org.soaspark.persistence;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersistenceManager {

	private String persistenceUnitName;
	
	protected PersistenceManager(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}
	
	@SuppressWarnings("unused")
	private PersistenceManager() {
		super();
	}
	
	@Produces
	@SessionScoped
	protected EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}
	
}
