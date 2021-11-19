package t3;

//Act 3 - Contador

public class Contador implements Runnable {

	private String nombreHilo;
	private int inicioContador;
	private int limiteContador;
	
	public Contador() {
		
	}
	
	public Contador(String nombreHilo, int inicioContador, int limiteContador) {
		this.nombreHilo = nombreHilo;
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
	}
	
	public static void main(String[] args) {
		Contador cont1 = new Contador("Contador 1", 0, (int) (Math.random() * (100 - 2)) + 2);
		Contador cont2 = new Contador("Contador 2", 0, (int) (Math.random() * (100 - 2)) + 2);
		Contador cont3 = new Contador("Contador 3", 0, (int) (Math.random() * (100 - 2)) + 2);
		Contador cont4 = new Contador("Contador 4", 0, (int) (Math.random() * (100 - 2)) + 2);
		Contador cont5 = new Contador("Contador 5", 0, (int) (Math.random() * (100 - 2)) + 2);
		
		Thread hilo1 = new Thread(cont1);
		Thread hilo2 = new Thread(cont2);
		Thread hilo3 = new Thread(cont3);
		Thread hilo4 = new Thread(cont4);
		Thread hilo5 = new Thread(cont5);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
	}

	@Override
	public void run() {
		for (int i = this.inicioContador; i < this.limiteContador; i++) {
			System.out.println(this.nombreHilo + " " + i);
		}
		
	}

}
