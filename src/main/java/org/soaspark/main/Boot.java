package org.soaspark.main;

import org.soaspark.persistence.BDPersistence;
import org.soaspark.utils.CDIWeldUtil;

/**
 * Hello world!
 *
 */
public class Boot {
	
	public static void main(String[] args) throws Exception {
		
		inicializarWeldCDI();
		inicializarBD();
		
//		get("/hello", (req, res) -> "Hello World");
//		get("/hello/:nome", (req, res) -> "Hello " + req.params(":nome"));
//		
//		post("/data-hora-atual", (req, res) -> {
//			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
//		});
//		
//		post("/dados-body", (req, res) -> {
//			System.out.println(req.body());
//			return "OK";
//		});
		
//		get("/buscar-cliente", (req, res) -> {
//			Weld weld = new Weld();
//			WeldContainer container = weld.initialize();
//			RequestContext requestContext= container.instance().select(RequestContext.class, UnboundLiteral.INSTANCE).get();
//		    requestContext.activate();
//			ClienteController cc = container.instance().select(ClienteController.class).get();
//			weld.shutdown();
//			cc.buscar();
////			cc.teste();
//			return "OK";
//		});
		
	}

	private static void inicializarBD() {
		try {
			BDPersistence.values()[0].getEntityManager();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void inicializarWeldCDI() throws Exception {
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
