package org.soaspark.hello;

import javax.inject.Singleton;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@Singleton
public class Application {
	
	public void testarWeld() {
		System.out.println("INFO: CDI com implementacao JBoss Weld carregado.");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T criarInjectManual(T clazz) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		T obj = (T) container.instance().select(clazz.getClass()).get();
		weld.shutdown();
		return obj;
	}
	
}
