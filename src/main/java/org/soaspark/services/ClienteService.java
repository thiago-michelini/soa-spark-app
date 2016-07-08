package org.soaspark.services;

import static org.soaspark.persistence.BDPersistence.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.soaspark.entity.Cliente;
import org.soaspark.repository.ClienteRepository;

public class ClienteService {
	
	public Cliente gravar() {
		Cliente c = new Cliente();
		c.setNome("Thiago Michelini");
		try {			
			ClienteRepository rpst = new ClienteRepository(BD_HSQL);
			return rpst.gravar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void listar() {
		try {
			EntityManager em = BD_HSQL.getEntityManager();
			List<Cliente> list = em.createQuery("FROM Cliente c", Cliente.class).getResultList();
			em.close();
			
			list.forEach(item -> {
				System.out.println("Id: "+item.getId()+" | Nome: "+item.getNome());
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Cliente editar(String nome) throws Exception {
		ClienteRepository rpst = new ClienteRepository(BD_HSQL);
		Cliente c = rpst.buscarPorId(1L);
		c.setNome(nome);
		try {			
			return rpst.gravar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
