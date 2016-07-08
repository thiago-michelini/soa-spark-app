package org.soaspark.persistence;

import javax.persistence.EntityManager;

public class RepositoryBase {

	private BDPersistence BD;
	
	protected RepositoryBase(BDPersistence BD) {
		this.BD = BD;
	}
	
	protected <T extends EntidadeBase> T gravar(T entidade) throws Exception {
		EntityManager em = BD.getEntityManager();
		em.getTransaction().begin();
		if (null == entidade.getId())
			em.persist(entidade);
		else
			em.merge(entidade);
		em.getTransaction().commit();
		fecharEm(em);
		
		return entidade;
	}
	
	protected <T extends EntidadeBase> void excluir(T entidade) throws Exception {
		EntityManager em = BD.getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		fecharEm(em);
	}
	
	protected <T> T buscarPorId(Class<T> clazz, Long id) {
		return BD.getEntityManager().find(clazz, id);
	}
	
	private void fecharEm(EntityManager em) throws Exception {
		em.close();
	}
	
}
