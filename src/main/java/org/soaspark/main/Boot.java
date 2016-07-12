package org.soaspark.main;

import org.soaspark.persistence.BDPersistence;
import org.soaspark.utils.CDIWeldUtil;

public class Boot {
	
	public static void main(String[] args) throws Exception {
		inicializarBD();
		carregarAplicacao();
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
			app.carregarPOJOsJAXB();
			app.carregarServicosRest();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
