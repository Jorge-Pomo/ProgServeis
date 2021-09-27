package t1;

import java.util.Scanner;

public class act8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] mesos = {"gener", "febrer", "març", "abril", "maig", "juny", "juliol", "agost", "septembre", "octubre", "novembre", "desembre"};

		System.out.println("Dime un número del 1 al 12");
		int num = sc.nextInt();
		
		System.out.println(mesos[num-1]);
	}

}
