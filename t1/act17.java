package t1;

import java.util.Scanner;

public class act17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce contraseña: ");
		String contra = sc.nextLine();

		if (contra.length() < 5) {
			System.err.println("La contraseña deve contener como mínimo 5 caracteres");
		}

		if (contieneMayus(contra) == false) {
			System.err.println("La contraseña no contiene ninguna mayuscula");
		}

		if(contieneNum(contra) == false) {
			System.err.println("La contraseña no contiene un número");
		}
		
	}

	public static boolean contieneMayus(String s) {
		if (s.equals(s.toLowerCase())) {
			return false;
		}

		return true;
	}

	public static boolean contieneNum(String s) {
		char[] caracteres = s.toCharArray();

		int cont = 0;

		for (int i = 0; i < caracteres.length; i++) {

			if (isNumeric(String.valueOf(caracteres[i]))) {
				cont++;
			}
		}

		if (cont >= 1) {
			cont = 0;
			return true;
		} else {
			return false;
		}
	}

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
