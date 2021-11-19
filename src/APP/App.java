package APP;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Mina mina = new Mina(1000);
		int numEnjambre = 15;
		
		ArrayList<Minero> mineros = new ArrayList();
		ArrayList<Thread> hilos = new ArrayList();
		
		for (int i = 0; i < numEnjambre; i++) {
			// Creant Mineros
			Minero minero = new Minero(mina);
			mineros.add(minero);
			
			// Creant Hilos
			Thread hilo = new Thread(minero);
			hilos.add(hilo);
			
			hilos.get(i).start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int cantidadTotal = 0;
		for (int i = 0; i < numEnjambre; i++) {
			cantidadTotal += mineros.get(i).bolsa;
			System.err.println(mineros.get(i).bolsa);
		}
		
		System.err.println("La cantidad total de oro es: " + cantidadTotal);
		
	}

}
