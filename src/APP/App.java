package APP;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Mina mina = new Mina(100);
		int numEnjambre = 15;
		
		for (int i = 0; i < numEnjambre; i++) {
			Minero minero = new Minero(mina);
			
			Thread hilo = new Thread(minero);
			
			hilo.start();
		}
		
	}

}
