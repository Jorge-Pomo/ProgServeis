package t1;

import java.util.Scanner;

public class act16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime la fecha de tu nacimiento (DD-MM-AAAA)");
		String strFecha = sc.nextLine();
		
		strFecha = strFecha.replace("-", "");
		int numSuerte = 0;
		
		for (int i = 0; i < strFecha.length(); i++) {
			numSuerte = numSuerte + Integer.parseInt(String.valueOf(strFecha.charAt(i)));
		}
		
		System.out.println(numSuerte = Integer.parseInt(String.valueOf(String.valueOf(numSuerte).charAt(0))) + Integer.parseInt(String.valueOf(String.valueOf(numSuerte).charAt(1))));
	}

}
