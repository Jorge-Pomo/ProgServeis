package t3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Caracol3 implements Runnable {

	private double velocidad;
	private String nombre;

	public Caracol3() {

	}

	public Caracol3(double velocidad, String nombre) {
		this.velocidad = velocidad;
		this.nombre = nombre;

	}

	public static void main(String[] args) {
		Caracol3 caracol1 = new Caracol3(0.02, "Caracol 1");
		Caracol3 caracol2 = new Caracol3(0.02, "Caracol 2");
		Caracol3 caracol3 = new Caracol3(0.02, "Caracol 3");
		Caracol3 caracol4 = new Caracol3(0.02, "Caracol 4");
		Caracol3 caracol5 = new Caracol3(0.02, "Caracol 5");

		Thread hilo1 = new Thread(caracol1);
		Thread hilo2 = new Thread(caracol2);
		Thread hilo3 = new Thread(caracol3);
		Thread hilo4 = new Thread(caracol4);
		Thread hilo5 = new Thread(caracol5);

		hilo1.setPriority(1);
		hilo2.setPriority(3);
		hilo3.setPriority(5);
		hilo4.setPriority(7);
		hilo5.setPriority(9);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();

	}

	@Override
	public void run() {
		int cm = 100;
		double cont = this.velocidad;
		String distancia = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\src\\t3\\arxiuCaragol3\\resultat.txt"));
			String linea = br.readLine();

			while (cont < cm) {
				// Comprovem arxiu
				linea = br.readLine();
				if (linea != null) {
					break;
				}

				distancia = String.format("%.2f", cont);
				System.out.println("El caracol " + this.nombre + " ha recorrido ja un " + distancia + "%");
				cont += cont;
			}

			String fin = "El caracol " + this.nombre + " ha completado la carrera";

			linea = br.readLine();
			if(linea == null) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\t3\\arxiuCaragol3\\resultat.txt"));
				bw.write(fin);
				bw.close();
			}
			
			br.close();
			System.err.println(fin);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}