package t2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class act3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Definim variables agafades dels "args"
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);

		String fitxerDesti = args[2];

		System.out.println(sumaNumeros(num1, num2));
		System.out.println(escribirResultado(sumaNumeros(num1, num2), fitxerDesti));

	}

	public static int sumaNumeros(int num1, int num2) {
		int grandaria = num2 - num1;
		int[] intervalo = new int[grandaria + 1];

		int cont = 0;
		int suma = 0;

		for (int i = num1; i <= num2; i++) {
			intervalo[cont] = i;
			suma = suma + i;
			cont++;
		}

		return suma;
	}

	public static String escribirResultado(int resuSuma, String fitxerDesti) {

		String resultatEscritura = "";

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fitxerDesti));

			bw.write(String.valueOf(resuSuma));

			resultatEscritura = "Exit en l'escritura";

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();

			resultatEscritura = "Error en l'escritura";
		}

		return resultatEscritura;
	}

}
