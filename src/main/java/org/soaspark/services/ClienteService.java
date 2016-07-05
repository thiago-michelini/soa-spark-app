package org.soaspark.services;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.soaspark.persistence.Dao;

public class ClienteService {
	
	@Inject
	private Dao em;

	public <T> void gravar(T entidade) {
		em.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
		em.getEntityManager();
		System.out.println("find... id->" + id);
		return (T) new BigDecimal(id.intValue());
	}
	
}
