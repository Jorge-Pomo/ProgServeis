package t1;

public class act24 {

	public static void main(String[] args) {
		int numE = Integer.parseInt(args[0]);

		System.out.println(numE);
		
		double numAle = Math.random() * (11 - 1) + 1;
		System.out.println((int) numAle);

		if(numAle - numE == 0) {
			System.out.println("Premio");
		}else {
			System.out.println("Perdiste");
		}
		
	}

}
