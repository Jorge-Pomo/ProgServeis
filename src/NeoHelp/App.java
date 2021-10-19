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
	
	// leerNeo()
	// No te cap parametres d'entrada
	// Eixida: retorna un arrayList que conte un array de 3 posicions amb les
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

	// lanzarProbabilidad(String[])
	// Parametres d'entrada: un array de 3 posicións que conte el nom, posició i velocitat del neo.
	// Eixida: retorna el process que s'esta ejecutant
	public static Process lanzarProbabilidad(String[] caracteristicas) {

		String n1 = caracteristicas[0];
		String n2 = caracteristicas[1];
		String n3 = caracteristicas[2];

		String clase = "NeoHelp.CalcularProbabilidadImpacto";

		Process process = null;

		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			// Command
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);

			// Enviem arguments a la clase "className"
			command.add(n1);
			command.add(n2);
			command.add(n3);

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

	// Main
	public static void main(String[] args) {
		// Iniciem temporitzador
		long inicio = System.currentTimeMillis();

		Process process = null;

		ArrayList<String[]> contenido = leerNeo();

		// funció que retorna el num de subprocesos que pot ejecutar el processador
		int numCores = Runtime.getRuntime().availableProcessors();
		int cont = 0;

		// calculem sols la probabilitat de 8 NEOs
		for (int i = 0; i < numCores; i++) {
			process = lanzarProbabilidad(contenido.get(cont));
			cont++;
		}

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Calcular temps
		long fin = System.currentTimeMillis();

		double tiempo = (double) ((fin - inicio) / 1000);

		try {
			Thread.sleep(500);
			System.out.println("Fin");	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(tiempo + " segundos");
	}
}
