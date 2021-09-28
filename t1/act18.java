package t1;

import java.util.Scanner;

public class act18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce contraseña: ");
		String contra = sc.nextLine();

		int err = 0;
		
		if (contra.length() < 5) {
			System.err.println("La contraseña deve contener como mínimo 5 caracteres");
			err++;
		}

		if (contieneMayus(contra) == false) {
			System.err.println("La contraseña no contiene ninguna mayuscula");
			err++;
		}

		if(contieneNum(contra) == false) {
			System.err.println("La contraseña no contiene un número");
			err++;
		}
		
		if(err == 0) {
			System.out.println("Repetir contraseña:");
			String repContra = sc.nextLine();
			
			if(contra.equals(repContra)) {
				System.out.println("Contraseña correcta");
			}else {
				System.err.println("Las contraseñas no coinciden");
			}
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
