package org.soaspark.endpoints;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.soaspark.services.ClienteService;

//@ApplicationScoped
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
