package t1;

import java.util.Iterator;
import java.util.Scanner;

public class act6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		int suma = 0;
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Dime un n�mero: ");
			num = sc.nextInt();
			suma = suma + num;
		}
		
		System.out.println("La suma dels n�meros �s " + suma);
	}

}
