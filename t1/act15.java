package t1;

import java.util.Scanner;

public class act15 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);

		System.out.println("Valor del radio de una circunferencia: ");
		double radio = sc.nextDouble();
		
		double diametro = radio * 2;
		double area = Math.PI * Math.pow(radio, 2);
		double volumen = (4 * Math.PI * Math.pow(radio, 3)) / 3;
		
		System.out.printf("%.3f", diametro);
		System.out.println(" Diametro");
		
		System.out.printf("%.3f", area);
		System.out.println(" Area");
		
		System.out.printf("%.3f", volumen);
		System.out.println(" Volumen");
	}

}
