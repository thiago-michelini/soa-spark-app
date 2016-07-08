package org.soaspark.main;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.soaspark.endpoints.ClienteRestService;

//@ApplicationScoped
public class Application {
	
	@Inject
	private ClienteRestService clienteRestService;
	
	public void testarWeld() {
		System.out.println("INFO: CDI com implementacao JBoss Weld carregado.");
	}
	
	public void carregarServicosRest() {
		clienteRestService.definirSparkServices();
	}
	
}
