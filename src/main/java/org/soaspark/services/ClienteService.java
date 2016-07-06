package org.soaspark.services;

import static org.soaspark.persistence.BDPersistencia.BANCO1;

import javax.persistence.EntityManager;

import org.soaspark.entity.Cliente;

public class ClienteService {

	public <T> void gravar(T entidade) {
		BANCO1.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
		try {
			EntityManager em = BANCO1.getEntityManager();
//			System.out.println("find... id->" + id);
//			return (T) em.find(Cliente.class, 1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
