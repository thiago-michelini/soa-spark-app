package org.soaspark.main;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.soaspark.entity.Produto;
import org.soaspark.persistence.BDPersistence;
import org.soaspark.utils.CDIWeldUtil;

public class Boot {
	
	public static final String PACOTE_ROOT = "org.soaspark";
	
	public static void main(String[] args) throws Exception {
		inicializarBD();
		carregarAplicacao();
//		Produto p = new Produto();
//		p.setId(1L);
//		p.setNome("Melancia");
//		p.setEstoqueMinimo(10);
//		p.setValor(20.12);
//		
//		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
//		Marshaller marshaller = ctx.createMarshaller();
//		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
////		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		marshaller.marshal(p, System.out);
//		
//		Unmarshaller unmarshaller = ctx.createUnmarshaller();
//		unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//		unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
//		StreamSource json = new StreamSource(new StringReader("{\"produto\":{\"id\":100,\"valor\":2.6}}"));
//		Produto pUn = unmarshaller.unmarshal(json, Produto.class).getValue();
//		System.out.println("\n"+pUn.getId() + " | " + pUn.getValor());
	}

	private static void inicializarBD() {
		try {
			for (BDPersistence bd : BDPersistence.values())
				bd.getEntityManager();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void carregarAplicacao() throws Exception {
		try {
			Application app = CDIWeldUtil.criarBean(Application.class);
			app.testarWeld();
			app.carregarServicosRest();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
