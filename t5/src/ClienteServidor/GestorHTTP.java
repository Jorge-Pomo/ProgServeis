package ClienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {

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
	
	private String handleGetRequest(HttpExchange httpExchange) {
		return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}
	
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) {
		OutputStream outputStream = httpExchange.getResponseBody();
		//String htmlResponse = "<html><body>Hola "+requestParamValue+"</body></html>";
		String htmlResponse = paguinasWeb(requestParamValue);
		leerPeticionGet(requestParamValue);
		try {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String handlePostRequest(HttpExchange httpExchange) throws IOException {
		InputStream inputStream = httpExchange.getRequestBody();
		/* Procesar lo que hay en inputStream, por ejemplo linea a linea y guardarlo todo
		en un string, que sera el que devuelve el metodo
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		//StringBuilder out = new StringBuilder();
		String postRequest = "";
		
		try {
			while (true) {
				postRequest += br.readLine();
				if(br.readLine() != null) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contenidoPost(postRequest);
		
		return postRequest;
	}
	
	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "Respuesta a la petición POST";
		try {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ACTS
	// Act 6
	public static void leerPeticionGet(String respuesta) {
		System.out.println(respuesta); 
	}
	
	// Act 7
	public static String paguinasWeb(String peticion) {
		String respuesta = "";
		if(peticion.length() > 10) {
			respuesta = "<html><body><h1>Pag Web 1</h1> <p>La longitud de la peticion es mayor de 10</p></body></html>";
		}else {
			respuesta = "<html><body><h2>Pag Eb 2</h2> <p>La longitud de la peticion es menor o igual a 10</p></body></html>";
		}
		return respuesta;
	}
	
	// Act 9
	public static void contenidoPost(String respuesta) {
		System.out.println(respuesta);
	}
	
}