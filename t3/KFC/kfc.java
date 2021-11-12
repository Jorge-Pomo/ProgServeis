package t3.KFC;

import java.util.ArrayList;
import java.util.Random;

public class kfc {

	public static void main(String[] args) {
		boteAlitas bote = new boteAlitas();

		int numCompa�eros = 30;
		ArrayList<Compa�ero> listaCompa = new ArrayList();
		ArrayList<Thread> hilos = new ArrayList();

		// Crear compa�eros
		for (int i = 0; i < numCompa�eros; i++) {
			Random random = new Random();
			Compa�ero compa = new Compa�ero(random.nextInt(10 + 1) + 1, bote);
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
