package Act;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

	static Scanner sc = new Scanner(System.in);

	// Act 1 - sayHello
	// parametres de Entrada: null
	// parametres d'ixida: null
	public static String sayHello() {
		return "HolaMundo";
	}

	// Act 2 - array/ArrayList nom de Companys
	// parametres de Entrada: null
	// parametres d'ixida: null
	public static void nombreCompañeros() {
		String[] nomCompa = { "Joan", "Ximo", "Diego", "David", "Carlos", "Rene" };
		for (int i = 0; i < nomCompa.length; i++) {
			System.out.println(nomCompa[i]);
		}

		System.out.println();

		ArrayList<String> noms = new ArrayList<String>();
		for (int i = 0; i < nomCompa.length; i++) {
			noms.add(nomCompa[i]);
		}
		for (int i = 0; i < noms.size(); i++) {
			System.out.println(noms.get(i));
		}
	}

	// Act 3 - nPars
	// paramentre de entrada: int amb el número acceptat per parámetro
	// parametre d'ixida: int amb la suma de tots els números pars
	public static int nPars(int num) {
		int suma = 0;

		for (int i = 0; i <= num; i += 2) {
			suma = i + suma;
		}
		return suma;
	}

	// Act 4 - factorial
	// paramentre de entrada: null
	// parametre d'ixida: null
	public static void factorial() {
		int numFactorizar = 15;
		long resuMulti = 1;

		for (int i = 1; i <= numFactorizar - 1; i++) {
			resuMulti = resuMulti * (i + 1);
		}
		System.out.println("El factorial de 15 es = " + resuMulti);
	}

	// Act 5 - mayor
	// paramentre de entrada: array d'enters
	// parametre d'ixida: int amb el major de l'array d'enters
	public static int mayor(int[] elementos) {
		int resu = 0;

		for (int i = 0; i < elementos.length; i++) {
			if (resu < elementos[i]) {
				resu = elementos[i];
			}
		}

		return resu;
	}

	// Act 6 - ordenarSumar
	// paramentre de entrada: array amb 5 numeros enters
	// parametre d'ixida: int amb la suma de tots els números pars
	public static void ordenarSumar(int[] numEnteros) {
		int resu = 0;

		for (int i = numEnteros.length - 1; i >= 0; i--) {
			System.out.println(i + 1);

			resu = resu + numEnteros[i];
		}

		System.out.println("La suma de los numeros es = " + resu);
	}

	// Act 7 - Salario desarrollador
	// parametres d'entrada: null
	// parametres d'iida: null
	public static void nivelSalario() {
		System.out.print("Dime tu nombre: ");
		String nom = sc.nextLine();

		System.out.print("Dime los años de experiencia como desarrollador de software: ");
		double años = sc.nextDouble();

		if (años <= 1) {
			System.out.println(nom + " sera un Dessarrollador Junior L1 y cobrara entre 15000-18000 €/Año");
		} else {
			if (años > 1 && años <= 2) {
				System.out.println(nom + " sera un Dessarrollador Junior L2 y cobrara entre 18000-22000 €/Año");
			} else {
				if (años >= 3 && años <= 5) {
					System.out.println(nom + " sera un Dessarrollador Seniro L1 y cobrara entre 22000-28000 €/Año");
				} else {
					if (años >= 5 && años <= 8) {
						System.out.println(nom + " sera un Dessarrollador Senior L2 y cobrara entre 28000-36000 €/Año");
					} else {
						if (años < 8) {
							System.out.println(nom
									+ " sera un Analista / Arquitecto. Tendara un salario a convenir en base a rol");
						}
					}
				}
			}
		}
	}

	// Act8 - Intervalo
	// parametres d'entrada: null
	// parametres d'ixida: null
	public static void intervalo() {

		System.out.println("Dime el primer número de un intervalo: ");
		int num1 = sc.nextInt();

		System.out.println("Dime el ultimo número de un intervalo: ");
		int num2 = sc.nextInt();

		int grandaria = num2 - num1;

		int[] intervalo = new int[grandaria + 1];

		int cont = 0;

		long startTime = System.nanoTime();
		for (int i = num1; i <= num2; i++) {
			intervalo[cont] = i;

			if (primo(i)) {
				System.out.println(i + " Es primo");
			} else {
				System.out.println(i + " No primo");
			}

			cont++;
		}

		System.out.println((System.nanoTime() - startTime) + " nanosegons");
	}

	// esPrimo?
	// parametres d'entrada: un número enter
	// parametres d'ixida: valor bolea diguent si es prim(True) o si no és
	// prim(False)
	public static boolean primo(int num) {
		// El 0 - 1 - 4 no son números primos
		if (num == 0 || num == 1 || num == 4) {
			return false;
		}

		// i < num / 2, para no entrar tantas veces, asi reducimos el número sin afectar
		// a si es primo o no es primo
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Main
	public static void main(String[] args) {

		System.out.println("Activitat Evaluable 1 \n");
		System.out.println("Menu Activitats:");
		System.out.println("1.    Hola Mundo");
		System.out.println("2.    Array con 6 elementos");
		System.out.println("3.    Suma de números pars");
		System.out.println("4.    Calcular el factorial del 15");
		System.out.println("5.    Número major del array");
		System.out.println("6.    Donats 5 nums, ordenarlos de menor a major i sumarlos");
		System.out.println("7.    Anys d'experiencia i sou");
		System.out.println("8.    Donats 2 números imprimir tots els números d'ixe interval \n");

		System.out.print("Indica l'activitat que vols mostrar: ");
		String numAct = sc.nextLine();

		switch (Integer.parseInt(numAct)) {
		case 1:
			// Act 1

			System.out.println(sayHello());
			break;

		case 2:
			// Act 2

			nombreCompañeros();
			break;

		case 3:
			// Act 3

			System.out.println("\nLa suma de los enteros es = " + nPars(Integer.parseInt(args[0])));
			break;

		case 4:
			// Act 4

			factorial();

			break;

		case 5:
			// Act 5

			int[] nums = { 1, 3, 50, 196, 4, 22, 29, 350, 6, -8, 9 };
			System.out.println(mayor(nums));

			break;

		case 6:
			// Act 6
			int[] numeros = new int[5];

			for (int i = 0; i < numeros.length; i++) {
				System.out.print("Dime un número: ");
				numeros[i] = sc.nextInt();
			}

			ordenarSumar(numeros);

			break;

		case 7:
			// Act 7

			nivelSalario();

			break;

		case 8:
			// Act 8

			intervalo();

			break;

		}
	}
}
