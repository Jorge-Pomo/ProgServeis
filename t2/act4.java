package t2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class act4 {

	public void lanzarAct3(Integer n1, Integer n2, String n3) {

		// Nom de la clase a la que volem cridar
		String clase = "t2.act3";
		try {

			String javaHome = System.getProperty("java.home");
			// Ruta on es troba Java instalat
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			// Ruta de la clase que anem a cridar
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			// Nom de la calse
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);

			// Enviem arguments a la clase "className"
			command.add(n1.toString());
			command.add(n2.toString());
			command.add(n3);

			System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.start();
			// Process process = builder.start();
			process.waitFor();
			System.out.println(process.exitValue());

			// Llegir arxiu
			BufferedReader br = new BufferedReader(new FileReader(n3));
			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		act4 l = new act4();
		l.lanzarAct3(1, 100, ".\\src\\t2\\fitxers\\resuAct3.txt");
		System.out.println("Ok");

	}

}
