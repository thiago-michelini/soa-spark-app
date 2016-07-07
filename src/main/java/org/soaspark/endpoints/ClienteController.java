package org.soaspark.endpoints;

import javax.inject.Inject;

import org.jboss.weld.environment.se.contexts.interceptors.ActivateRequestScope;
import org.soaspark.services.ClienteService;

//@ApplicationScoped
public class ClienteController {

	@Inject
	private ClienteService service;
	
	@ActivateRequestScope
	public Object buscar() {
		return service.findById(1L);
	}
	
	public void teste() {
		System.out.println("testando...");
	}
	
}
