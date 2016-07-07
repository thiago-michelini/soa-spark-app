package org.soaspark.services;

//import static org.soaspark.persistence.BDPersistence.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.soaspark.entity.Cliente;
import org.soaspark.persistence.TesteBD;

public class ClienteService {

	@Inject
	private TesteBD bd;
	
	public <T> void gravar(T entidade) {
//		BANCO1.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
		try {
//			EntityManager em = BD_HSQL.getEntityManager();
			EntityManager em = bd.getEm();
			
			Cliente c = new Cliente();
//			c.setId(1);
			c.setNome("Thiago Michelini");
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			
			List<Cliente> list = em.createQuery("FROM Cliente c", Cliente.class).getResultList();
			
			bd.closeEm(em);
			
			list.forEach(item -> {
				System.out.println("Id: "+item.getId()+" | Nome: "+item.getNome());
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
