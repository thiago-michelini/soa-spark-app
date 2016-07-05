package org.soaspark.hello;

import static spark.Spark.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Hello world!
 *
 */
public class Hello {
	
	public static void main(String[] args) {
		
		inicializarWeldCDI();
//		new Application().run();
		
		get("/hello", (req, res) -> "Hello World");
		get("/hello/:nome", (req, res) -> "Hello " + req.params(":nome"));
		
		post("/data-hora-atual", (req, res) -> {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		});
		
		post("/dados-body", (req, res) -> {
			System.out.println(req.body());
			return "OK";
		});
		
	}
	
	private static void inicializarWeldCDI() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Application app = container.instance().select(Application.class).get();
		app.run();
		weld.shutdown();
	}
	
}
