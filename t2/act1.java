package t2;

import java.util.Scanner;

public class act1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Definim variables agafades dels "args"
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);

		System.out.println(sumaNumeros(num1, num2));

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
	

}
