package t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class act12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] notas = new int[10];
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Dime una nota entre el 0 y el 10: ");
			notas[i] = sc.nextInt();
		}

		ArrayList<Integer> suspenso = new ArrayList<>();
		ArrayList<Integer> aprobado = new ArrayList<>();
		ArrayList<Integer> notable = new ArrayList<>();
		ArrayList<Integer> sobresaliente = new ArrayList<>();
		ArrayList<Integer> matricula = new ArrayList<>();

		for (int i = 0; i < notas.length; i++) {
			if (notas[i] <= 4) {
				suspenso.add(notas[i]);
			}else {
				if(notas[i] == 5) {
					aprobado.add(notas[i]);
				}else {
					if(notas[i] >= 6 && notas[i] <= 8) {
						notable.add(notas[i]);
					}else {
						if(notas[i] == 9) {
							sobresaliente.add(notas[i]);
						}else {
							matricula.add(notas[i]);
						}
					}
				}
			}
		}
		
		System.out.println("Suspenso: ");
		for (int i = 0; i < suspenso.size(); i++) {
			System.out.println(suspenso.get(i));
		}
		System.out.println("Aprobado: ");
		for (int i = 0; i < aprobado.size(); i++) {
			System.out.println(aprobado.get(i));
		}
		System.out.println("Notable: ");
		for (int i = 0; i < notable.size(); i++) {
			System.out.println(notable.get(i));
		}
		System.out.println("Sobresaliente: ");
		for (int i = 0; i < sobresaliente.size(); i++) {
			System.out.println(sobresaliente.get(i));
		}
		System.out.println("Matricula: ");
		for (int i = 0; i < matricula.size(); i++) {
			System.out.println(matricula.get(i));
		}
	}

}
