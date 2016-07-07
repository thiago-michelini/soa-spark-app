package org.soaspark.persistence;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TesteBD {

	@Produces
	@SessionScoped
	public EntityManager getEm() {
		return Persistence.createEntityManagerFactory("hsql-PU").createEntityManager();
	}
	
	public void closeEm(@Disposes EntityManager em) {
		em.close();
	}

}
