package org.soaspark.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Singleton;

import org.reflections.Reflections;
import org.soaspark.endpoints.cliente.ServicoRestSpark;
import org.soaspark.utils.CDIWeldUtil;

@Singleton
public class Application {
	
	private static final List<String> pacotesServicosRest = new ArrayList<String>();
//	private static final List<String> pacotesServicosRest = new ArrayList<String>();
	static {
		pacotesServicosRest.add("org.soaspark.endpoints.cliente");
		pacotesServicosRest.add("org.soaspark.endpoints.produto");
	}
	
	public void testarWeld() {
		System.out.println("INFO: CDI com implementacao JBoss Weld carregado.");
	}
	
	public void carregarServicosRest() throws Exception {
		
		pacotesServicosRest.forEach((pacote) -> {
			
			Reflections reflections = new Reflections(pacote);
			System.out.println("INFO: Carregando classes de resource REST do pacote " + pacote);
			Set<Class<? extends ServicoRestSpark>> classes = reflections.getSubTypesOf(ServicoRestSpark.class);
			if (null == classes || classes.isEmpty())
				System.out.println("WARN: nao foi localizada nenhuma classe de resource REST no projeto, "
					+ "verifique se a constante PACOTE_ROOT foi definida corretamente");
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
			
		});
		
	}
	
}
