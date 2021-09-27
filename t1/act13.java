package t1;

import java.util.Scanner;

public class act13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dime  los grados centígrados: ");
		double centigrados = sc.nextDouble();
		
		double fahrenheit = centigrados * 33.8;
		
		System.out.printf("%.1f", fahrenheit);
		System.out.println("f");
	}

}
