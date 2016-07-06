package org.soaspark.persistence;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BancoDados1 {// extends PersistenceManager {

//	public BancoDados1() {
//		super("pg-PU");
//	}
	
	@Produces
	@SessionScoped
	public EntityManager getEntityManager() {
//		return super.getEntityManager();
		return Persistence.createEntityManagerFactory("pg-PU").createEntityManager();
	}

}
