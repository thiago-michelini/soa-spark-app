package org.soaspark.main;

import java.util.Set;

import javax.inject.Singleton;

import org.reflections.Reflections;
import org.soaspark.endpoints.ServicoRestSpark;
import org.soaspark.utils.CDIWeldUtil;

@Singleton
public class Application {
	
	public void testarWeld() {
		System.out.println("INFO: CDI com implementacao JBoss Weld carregado.");
	}
	
	public void carregarServicosRest(String rootPackage) throws Exception {
		Reflections reflections = new Reflections(rootPackage);
		System.out.println("INFO: Carregando classes de resource REST...");
		Set<Class<? extends ServicoRestSpark>> classes = reflections.getSubTypesOf(ServicoRestSpark.class);
		if (null == classes || classes.isEmpty())
			System.out.println("WARN: nao foi localizada nenhuma classe de resource REST no projeto");
		else
			classes.forEach((item) -> {
				try {
					ServicoRestSpark rest = CDIWeldUtil.criarBean(item);
					rest.definirServicosSpark();
					System.out.println("INFO: REST resource --> "+item.getName());
				} catch (Exception e) {
					System.err.println("ERRO: erro ao criar REST resource "+item.getName());
					e.printStackTrace();
				}
			});
	}
	
}
