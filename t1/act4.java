package t1;

import java.util.Scanner;

public class act4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Disme un número: ");
		int num1 = sc.nextInt();
		
		System.out.print("Disme un altre número: ");
		int num2 = sc.nextInt();
		
		if(num1 == num2) {
			System.out.println("Els números son iguals");
		}else {
			if(num1 > num2) {
				System.out.println("El número " + num1 + " és major al " + num2);
			}else {
				System.out.println("El número " + num1 + " és menor al " + num2);
			}
		}

	}

}
