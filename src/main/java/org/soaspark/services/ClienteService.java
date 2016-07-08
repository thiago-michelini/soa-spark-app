package org.soaspark.services;

import static org.soaspark.persistence.BDPersistence.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.soaspark.entity.Cliente;
import org.soaspark.repository.ClienteRepository;

public class ClienteService {
	
	public <T> void gravar(T entidade) {
//		BANCO1.getEntityManager();
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	public <T> T findById(Long id) {
		try {
			Cliente c = new Cliente();
//			c.setId(1);
			c.setNome("Thiago Michelini");
			
			ClienteRepository rpst = new ClienteRepository(BD_HSQL);
			rpst.gravar(c);
			
			EntityManager em = BD_HSQL.getEntityManager();
			List<Cliente> list = em.createQuery("FROM Cliente c", Cliente.class).getResultList();
			em.close();
			
			list.forEach(item -> {
				System.out.println("Id: "+item.getId()+" | Nome: "+item.getNome());
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
