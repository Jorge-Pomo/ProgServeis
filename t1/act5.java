package t1;

import java.util.Scanner;

public class act5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		
		do {
			System.out.print("Disme un n�mero: ");
			num1 = sc.nextInt();
			System.out.print("Disme un altre n�mero: ");
			num2 = sc.nextInt();
			
		}while(num1 != num2);

	}

}
