package NeoHelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

	// i5 - 10210U;
	// nucleos = 4;
	// subprocesos = 8;

	// Retorna un arrayList que conte un array de 3 posicions amb les
	// caracteristicques dels NEOs
	public static ArrayList<String[]> leerNeo() {
		ArrayList<String[]> neos = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\src\\NeoHelp\\Arxius\\NEOs.txt"));
			String linea = "";

			while ((linea = br.readLine()) != null) {
				String[] caracteristicas = linea.split(",");
				neos.add(caracteristicas);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return neos;

	}

	public static Process lanzarProbabilidad(String[] caracteristicas) {

		String n1 = caracteristicas[0];
		String n2 = caracteristicas[1];
		String n3 = caracteristicas[2];

		// Nom de la clase a la que volem cridar
		String clase = "NeoHelp.CalcularProbabilidadImpacto";

		Process process = null;

		try {

			String javaHome = System.getProperty("java.home");
			// Ruta on es troba Java instalat
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			// Ruta de la clase que anem a cridar
			String classpath = System.getProperty("java.class.path");
			// System.out.println(classpath);
			// Nom de la calse
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);

			// Enviem arguments a la clase "className"
			command.add(n1);
			command.add(n2);
			command.add(n3);

			// System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			// System.out.println("Comando a ejecutar en cmd.exe: " +
			// command.toString().replace(",", ""));

			ProcessBuilder builder = new ProcessBuilder(command);
			process = builder.inheritIO().start();
			// Process process = builder.start();
			// process.waitFor();
			// System.out.println(process.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return process;
	}

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();

		Process process = null;

		ArrayList<String[]> contenido = leerNeo();

		int numCores = Runtime.getRuntime().availableProcessors();
		int cont = 0;

		for (int i = 0; i < numCores; i++) {

			process = lanzarProbabilidad(contenido.get(cont));
			cont++;
		}

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("8");

		System.out.println("Fin");

		// Calcular temps
		long fin = System.currentTimeMillis();

		double tiempo = (double) ((fin - inicio) / 1000);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(tiempo + " segundos");
	}
}
