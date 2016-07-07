package org.soaspark.main;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Application {
	
	public void testarWeld() {
		System.out.println("INFO: CDI com implementacao JBoss Weld carregado.");
	}
	
}
