package t3;

public class Caracol implements Runnable {

	private double velocidad;
	private String nombre;
	
	public Caracol() {
		
	}
	
	public Caracol(double velocidad, String nombre) {
		this.velocidad = velocidad;
		this.nombre = nombre;
		
	}
	
	public static void main(String[] args) {
		Caracol caracol1 = new Caracol((Math.random() * (1 - 0.1)) + 0.1, "Caracol 1");
		Caracol caracol2 = new Caracol((Math.random() * (1 - 0.1)) + 0.1, "Caracol 2");
		Caracol caracol3 = new Caracol((Math.random() * (1 - 0.1)) + 0.1, "Caracol 3");
		Caracol caracol4 = new Caracol((Math.random() * (1 - 0.1)) + 0.1, "Caracol 4");
		Caracol caracol5 = new Caracol((Math.random() * (1 - 0.1)) + 0.1, "Caracol 5");
		
		Thread hilo1 = new Thread(caracol1);
		Thread hilo2 = new Thread(caracol2);
		Thread hilo3 = new Thread(caracol3);
		Thread hilo4 = new Thread(caracol4);
		Thread hilo5 = new Thread(caracol5);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();

	}

	@Override
	public void run() {
		int cm = 100;
		int cont = 0;
		int distancia = 0;
		
		while(cont != cm) {
			cont++;
			
			
		}
		
	}

}
