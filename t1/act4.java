package t1;

import java.util.Scanner;

public class act4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Disme un n�mero: ");
		int num1 = sc.nextInt();
		
		System.out.print("Disme un altre n�mero: ");
		int num2 = sc.nextInt();
		
		if(num1 == num2) {
			System.out.println("Els n�meros son iguals");
		}else {
			if(num1 > num2) {
				System.out.println("El n�mero " + num1 + " �s major al " + num2);
			}else {
				System.out.println("El n�mero " + num1 + " �s menor al " + num2);
			}
		}

	}

}
