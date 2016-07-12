package org.soaspark.endpoints.produto;

import static spark.Spark.get;
import static spark.Spark.post;

import javax.inject.Inject;

import org.soaspark.endpoints.cliente.ServicoRestSpark;
import org.soaspark.services.ProdutoService;

public class ProdutoRestService extends ServicoRestSpark {

	@Inject
	private ProdutoService produtoService;
	
	@Override
	public void definirServicosSpark() {
		
		get("/produto/gravar", (req, res) -> {
			produtoService.gravar();
			return "OK Produto";
		});
		
		get("/produto/buscar", (req, res) -> {
			produtoService.listar();
			return "OK listar Produto";
		});
		
		post("/produto/editar", (req, res) -> {
			produtoService.editar(req.body());
			return "OK editar Produto";
		});
		
	}

}
