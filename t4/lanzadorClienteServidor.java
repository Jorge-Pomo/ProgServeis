package t4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class lanzadorClienteServidor {
	public void lanzarCliente() {
		String clase = "t4.Cliente";
		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			// Process process = builder.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lanzarServidor() {
		String clase = "t4.Servidor";
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			// Process process = builder.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		lanzadorClienteServidor c = new lanzadorClienteServidor();		
		c.lanzarServidor();
		c.lanzarCliente();
		
		System.out.println("Ok");

	}

}
