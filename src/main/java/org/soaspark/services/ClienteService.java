package org.soaspark.services;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.soaspark.entity.Cliente;
import org.soaspark.persistence.BancoDados1;

public class ClienteService {
	
	@Inject
	private BancoDados1 bd;

	public <T> void gravar(T entidade) {
//		BANCO1.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
		try {
			EntityManager em = bd.getEntityManager();
			
			em.getTransaction().begin();
			em.createNativeQuery("CREATE TABLE CLIENTE(ID INTEGER NOT NULL PRIMARY KEY,NOME VARCHAR(100))").executeUpdate();
			em.getTransaction().commit();
			
			Cliente c = new Cliente();
			c.setId(1);
			c.setNome("Thiago Michelini");
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			
			System.out.println("find... id->" + id);
			return (T) em.find(Cliente.class, 1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
