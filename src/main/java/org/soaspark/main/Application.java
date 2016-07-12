package org.soaspark.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Singleton;
import javax.xml.bind.annotation.XmlRootElement;

import org.reflections.Reflections;
import org.soaspark.endpoints.cliente.ServicoRestSpark;
import org.soaspark.utils.CDIWeldUtil;

@Singleton
public class Application {
	
	private static List<String> pacotesServicosRest = new ArrayList<String>();
	private static List<String> pacotesPOJOsJAXB = new ArrayList<String>();
	public static Set<Class<?>> POJOsJAXB;
	static {
		pacotesServicosRest.add("org.soaspark.endpoints.cliente");
		pacotesServicosRest.add("org.soaspark.endpoints.produto");
		
		pacotesPOJOsJAXB.add("org.soaspark.entity");
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
					+ "verifique se os pacotes adicionados na constante pacotesServicosRest foram definidos corretamente");
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
	
	public void carregarPOJOsJAXB() throws Exception {
		
		pacotesPOJOsJAXB.forEach((pacote) -> {
			
			Reflections reflections = new Reflections(pacote);
			System.out.println("INFO: Carregando classes de POJOs JAXB do pacote " + pacote);
			POJOsJAXB = reflections.getTypesAnnotatedWith(XmlRootElement.class);
			if (null == POJOsJAXB || POJOsJAXB.isEmpty())
				System.out.println("WARN: nao foi localizado nenhum POJO JAXB no projeto, "
					+ "verifique se os pacotes adicionados na constante pacotesPOJOsJAXB foram definidos corretamente");
			
		});
		
	}
	
}
