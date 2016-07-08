package org.soaspark.repository;

import org.soaspark.entity.Cliente;
import org.soaspark.persistence.BDPersistence;
import org.soaspark.persistence.RepositoryBase;

public class ClienteRepository extends RepositoryBase {

	public ClienteRepository(BDPersistence BD) {
		super(BD);
	}
	
	public Cliente gravar(Cliente entidade) throws Exception {
		return super.gravar(entidade);
	}
	
	public Cliente buscarPorId(Long id) throws Exception {
		return super.buscarPorId(Cliente.class, id);
	}

}
