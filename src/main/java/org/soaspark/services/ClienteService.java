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
