package org.soaspark.services;

import static org.soaspark.persistence.BDPersistence.BD_HSQL;

import java.util.List;

import javax.persistence.EntityManager;

import org.soaspark.entity.Produto;
import org.soaspark.repository.ProdutoRepository;

public class ProdutoService {

	public Produto gravar() {
		Produto p = new Produto();
		p.setNome("Laranja");
		p.setEstoqueMinimo(2000);
		p.setValor(1.52);
		try {			
			ProdutoRepository rpst = new ProdutoRepository(BD_HSQL);
			return rpst.gravar(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void listar() {
		try {
			EntityManager em = BD_HSQL.getEntityManager();
			List<Produto> list = em.createQuery("FROM Produto p", Produto.class).getResultList();
			em.close();
			
			list.forEach(item -> {
				System.out.println("Id: "+item.getId()+" | Nome: "+item.getNome()+" | EstMin.: "+item.getEstoqueMinimo()+" | Valor: "+item.getValor());
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Produto editar(String valor) throws Exception {
		ProdutoRepository rpst = new ProdutoRepository(BD_HSQL);
		Produto p = rpst.buscarPorId(1L);
		p.setValor(Double.parseDouble(valor));
		try {			
			return rpst.gravar(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
