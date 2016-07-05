package org.soaspark.hello;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.soaspark.services.ClienteService;

@Singleton
public class Application {

	@Inject
	private ClienteService service;
	
	public void run() {
		service.gravar(new String());
	}
	
}
