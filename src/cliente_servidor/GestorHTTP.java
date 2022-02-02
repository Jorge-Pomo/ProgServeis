package cliente_servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {

	// Atributs
	private int temperaturaActual = 15;
	private int temperaturaTermostato = 15;
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;
		if ("GET".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue);
		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handlePostRequest(httpExchange);
			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}

	//GET
	private String handleGetRequest(HttpExchange httpExchange) {
		return httpExchange.getRequestURI().toString().split("\\?")[1];
	}

	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) {
		OutputStream outputStream = httpExchange.getResponseBody();
		// String htmlResponse = "<html><body>Hola "+requestParamValue+"</body></html>";
		String htmlResponse = temptActualGet(requestParamValue);
		try {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//POST
	private String handlePostRequest(HttpExchange httpExchange) throws IOException {
		InputStream inputStream = httpExchange.getRequestBody();
		/*
		 * Procesar lo que hay en inputStream, por ejemplo linea a linea y guardarlo
		 * todo en un string, que sera el que devuelve el metodo
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		// StringBuilder out = new StringBuilder();
		String postRequest = "";
		String linea = "";
		
		linea = br.readLine();
		
		try {
			while (linea != null) {
				postRequest += linea;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int temperaturaPost = Integer.parseInt(postRequest.split("=")[1]);
		
		setTemperaturaPost(temperaturaPost);
		
		regularTemperatura(temperaturaPost);

		return postRequest;
	}

	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "Se ha enviado la peticion";
		try {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Metodos AE5
	// GET Mostrar temperaturas
	public String temptActualGet(String pregunta) {
			return "<html><body><h3>La temperatura actual es de</h3> <h4>" + this.temperaturaActual +"</h4> <h3>La temperatura del termostato es de</h3><h4>"+ this.temperaturaTermostato +"</body></html>";
	}
	
	// POST Poner temperaturas
	public void setTemperaturaPost(int temperatura) {
		System.out.println("Se ha enviado la peticion");
		this.temperaturaTermostato = temperatura;
	}

	public void regularTemperatura(int temperatura) {
		while(true) {
			if(temperaturaActual != this.temperaturaTermostato) {
				if(temperaturaActual < this.temperaturaTermostato) {
					this.temperaturaActual++;
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					this.temperaturaActual--;
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else {
				break;
			}
		}
	}

}
