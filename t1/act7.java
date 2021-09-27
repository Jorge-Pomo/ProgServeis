package t1;

import java.util.Scanner;

public class act7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		int suma = 0;
		int cont = 0;

		do {

			System.out.print("Dime un número: ");
			num = sc.nextInt();
			suma = suma + num;
			cont++;

		} while (cont != 5);

		System.out.println("La suma dels números és " + suma);

	}

}
