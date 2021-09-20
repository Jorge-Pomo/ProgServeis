package Act;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static String sayHello() {
		return "HolaMundo";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
		int numAct = sc.nextInt();

		switch (numAct) {
		case 1:
			// Act 1
			
			System.out.println(sayHello());
			break;

		case 2:
			// Act 2
			
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
			break;

		case 3:
			// Act 3
			
			break;
			
		case 4:
			//Act 4
			
			int numFactorizar = 15;
			int resuMulti = 1;
			for (int i = 0; i < numFactorizar-1; i++) {
				resuMulti = i * (i-1);
			}
			System.out.println(resuMulti);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
