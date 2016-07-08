package org.soaspark.main;

import org.soaspark.persistence.BDPersistence;
import org.soaspark.utils.CDIWeldUtil;

public class Boot {
	
	public static void main(String[] args) throws Exception {
		carregarAplicacao();
		inicializarBD();
	}

	private static void inicializarBD() {
		try {
			BDPersistence.values()[0].getEntityManager();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void carregarAplicacao() throws Exception {
		try {
			Application app = CDIWeldUtil.criarBean(Application.class);
			app.testarWeld();
			app.carregarServicosRest("org.soaspark");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
