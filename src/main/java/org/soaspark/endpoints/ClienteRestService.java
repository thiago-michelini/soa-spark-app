package org.soaspark.endpoints;

import javax.inject.Inject;

import org.soaspark.services.ClienteService;

import static spark.Spark.*;

public class ClienteRestService extends ServicoRestSpark {

	@Inject
	private ClienteService service;
	
	@Override
	public void definirServicosSpark() {
		get("/cliente/buscar", (req, res) -> {
			service.gravar();
			service.listar();
			return "OK";
		});
	}
	
}
