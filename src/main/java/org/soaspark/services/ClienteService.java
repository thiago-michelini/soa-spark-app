package org.soaspark.services;

import java.math.BigDecimal;

import javax.inject.Inject;

import static org.soaspark.persistence.BDPersistencia.*;

public class ClienteService {
	
//	@Inject
//	private BDPersistencia em;

	public <T> void gravar(T entidade) {
		BANCO1.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
//		BANCO1.getEntityManager();
		System.out.println("find... id->" + id);
		return (T) new BigDecimal(id.intValue());
	}
	
}
