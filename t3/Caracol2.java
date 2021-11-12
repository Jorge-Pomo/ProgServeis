package t3;

//Act 4 - Carrera Carqacol 1.2

public class Caracol2 implements Runnable {

	private double velocidad;
	private String nombre;
	
	public Caracol2() {
		
	}
	
	public Caracol2(double velocidad, String nombre) {
		this.velocidad = velocidad;
		this.nombre = nombre;
		
	}
	
	public static void main(String[] args) {
		Caracol caracol1 = new Caracol(0.02, "Caracol 1");
		Caracol caracol2 = new Caracol(0.02, "Caracol 2");
		Caracol caracol3 = new Caracol(0.02, "Caracol 3");
		Caracol caracol4 = new Caracol(0.02, "Caracol 4");
		Caracol caracol5 = new Caracol(0.02, "Caracol 5");
		
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
		
		while(cont < cm) {
			distancia = String.format("%.2f", cont);
			System.out.println("El caracol " + this.nombre + " ha recorrido ja un " + distancia + "%");
			cont += cont;
		}
		
		System.out.println("El caracol " + this.nombre + " ha completado la carrera");
	}

}
