package org.soaspark.endpoints;

import javax.inject.Inject;

import org.soaspark.services.ClienteService;

import static spark.Spark.*;

public class ClienteRestService extends ServicoRestSpark {

	@Inject
	private ClienteService service;
	
	@Override
	public void definirServicosSpark() {
		
		get("/cliente/gravar", (req, res) -> {
			service.gravar();
			return "OK";
		});
		
		get("/cliente/buscar", (req, res) -> {
			service.listar();
			return "OK";
		});
		
		post("/cliente/editar", (req, res) -> {
			service.editar(req.body());
			return "OK";
		});
		
	}
	
}
