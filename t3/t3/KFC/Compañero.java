package t3.KFC;

import java.util.ArrayList;
import java.util.Random;

// Act 5 - Alitas KFC

public class Compañero implements Runnable {

	public int consumir;
	private boteAlitas b;

	public Compañero() {

	}

	public Compañero(int consumir, boteAlitas b) {
		this.consumir = consumir;
		this.b = b;
	}

	@Override
	public void run() {
		consumirAlita();
	}

	synchronized public void consumirAlita() {
		int comprobar = b.alitas - consumir;
		
		if (comprobar >= 0) {
			b.alitas = b.alitas - consumir;
			System.out.println("Ha consumido " + consumir + " alitas, quedan " + b.alitas + " alitas");
		}else {
			consumir = 0;
			System.err.println("No ha podido consumir");
		}
	}

}
