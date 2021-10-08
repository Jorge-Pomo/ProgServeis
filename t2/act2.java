package t2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class act2 {

	public void lanzarSumador(Integer n1, Integer n2) {

		// Nom de la clase a la que volem cridar
		String clase = "t2.act1";
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

			System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			// Process process = builder.start();
			process.waitFor();
			System.out.println(process.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		act2 l = new act2();
		l.lanzarSumador(1, 100);
		System.out.println("Ok");

	}

}
