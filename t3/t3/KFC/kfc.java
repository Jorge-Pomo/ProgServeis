package t3.KFC;

import java.util.ArrayList;
import java.util.Random;

public class kfc {

	public static void main(String[] args) {
		boteAlitas bote = new boteAlitas();

		int numCompañeros = 30;
		ArrayList<Compañero> listaCompa = new ArrayList();
		ArrayList<Thread> hilos = new ArrayList();

		// Crear compañeros
		for (int i = 0; i < numCompañeros; i++) {
			Random random = new Random();
			Compañero compa = new Compañero(random.nextInt(10 + 1) + 1, bote);
			listaCompa.add(compa);
		}

		// Crear hilos
		for (int i = 0; i < listaCompa.size(); i++) {
			Thread hilo = new Thread(listaCompa.get(i));
			hilos.add(hilo);
			hilos.get(i).start();
		}
		
		int resConsumido = 0;
		for (int i = 0; i < listaCompa.size(); i++) {
			resConsumido += listaCompa.get(i).consumir;
		}
		
		System.out.println("Se han consumido = " + resConsumido + " alitas en total");

	}

}
