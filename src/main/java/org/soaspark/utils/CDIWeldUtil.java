package org.soaspark.utils;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Classe para gerenciamento de injecao de dependencias (CDI) com implementacao JBoss Weld
 * @author thiagomichelini
 *
 */
public class CDIWeldUtil {

	public static <T> T criarBean(Class<T> clazz) throws Exception {
		Weld weld = new Weld();
	    final WeldContainer container = weld.initialize();
	    T bean = container.instance().select(clazz).get();
	    weld.shutdown();
	    return bean;
	}
	
}
