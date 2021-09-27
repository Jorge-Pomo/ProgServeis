package t1;

import java.util.Scanner;

public class act3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un número: ");
		int num1 = sc.nextInt();
		
		System.out.print("Dime otro número: ");
		int num2 = sc.nextInt();
		
		System.out.println("La suma de " + num1 + " i " + num2 + " és " + (num1 + num2));

	}

}
