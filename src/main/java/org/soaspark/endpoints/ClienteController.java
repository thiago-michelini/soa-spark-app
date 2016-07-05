package org.soaspark.endpoints;

import javax.inject.Inject;

import org.soaspark.services.ClienteService;

public class ClienteController {

	@Inject
	private ClienteService service;
	
	public Object buscar() {
		return service.findById(1L);
	}
	
	public void teste() {
		System.out.println("testando...");
	}
	
}
