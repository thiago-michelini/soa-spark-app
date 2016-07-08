package org.soaspark.endpoints;

import javax.inject.Inject;

import org.soaspark.services.ClienteService;

import static spark.Spark.*;

public class ClienteRestService {

	@Inject
	private ClienteService service;

	public Object buscar() {
		return service.findById(1L);
	}
	
	public void definirSparkServices() {
		get("/cliente/buscar", (req, res) -> {
			service.findById(1L);
			return "OK";
		});
	}
	
}
