package t1;

import java.util.Scanner;

public class act11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime tu DNI sin letra: ");
		int dni = sc.nextInt();

		String strLetras  = "TRWAGMYFPDXBNJZSQVHLCKE";
		char[] letra = strLetras.toCharArray();
		
		char resuLetra = letra[dni%23];
		
		System.out.println("Tu letra del DNI es: " + resuLetra);
	}

}
