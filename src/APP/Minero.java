package APP;

public class Minero implements Runnable{

	public int bolsa;
	private int tiempoExtraccion;
	private Mina m;
	
	public Minero(Mina mina) {
		this.bolsa = 0;
		this.tiempoExtraccion = 1000;
		this.m = mina;
	}
	
	synchronized public void extraerRecurso(Mina m) {
		m.stock--;
		try {
			Thread.sleep(tiempoExtraccion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		do {
			extraerRecurso(m);
			System.out.println("El minero, " + Thread.currentThread().getName() + " quita una unidad");
			System.out.println("Quedan: " + m.stock + " unidades");
			bolsa++;
		}
		while(m.stock != 0);
		
		System.out.println(m.stock);
	}
	
}
