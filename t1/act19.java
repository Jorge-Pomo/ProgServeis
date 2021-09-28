package t1;

public class act19 {

	public static void main(String[] args) {
		int ascii = 32;
		
		for (int i = ascii; i < 127; i++) {
			 String convertedChar = Character.toString(i);
	         System.out.println(i+" => "+convertedChar);
		}

	}

}
