package org.soaspark.hello;

import static spark.Spark.get;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.soaspark.endpoints.ClienteController;
import org.soaspark.persistence.BDPersistence;

/**
 * Hello world!
 *
 */
public class Hello {
	
	private static Application app;
	
	public static void main(String[] args) {
		
		inicializarWeldCDI();
//		inicializarBD();
		
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
		
		get("/buscar-cliente", (req, res) -> {
			ClienteController cc = new ClienteController();
			cc = app.criarInjectManual(cc);
			cc.buscar();
//			cc.teste();
			return "OK";
		});
		
	}
	
	private static void inicializarBD() {
		try {
			BDPersistence.values()[0].getEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void inicializarWeldCDI() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		app = container.instance().select(Application.class).get();
		app.testarWeld();
		weld.shutdown();
	}
	
}
