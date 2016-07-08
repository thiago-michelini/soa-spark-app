package org.soaspark.repository;

import org.soaspark.entity.Produto;
import org.soaspark.persistence.BDPersistence;
import org.soaspark.persistence.RepositoryBase;

public class ProdutoRepository extends RepositoryBase {

	public ProdutoRepository(BDPersistence BD) {
		super(BD);
	}
	
	public Produto gravar(Produto entidade) throws Exception {
		return super.gravar(entidade);
	}
	
	public Produto buscarPorId(Long id) throws Exception {
		return super.buscarPorId(Produto.class, id);
	}

}
