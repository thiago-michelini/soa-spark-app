package org.soaspark.hello;

import static spark.Spark.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class Hello {
	
	public static void main(String[] args) {
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
	
}
