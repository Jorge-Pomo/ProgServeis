package t3.Entradas;

public class PSP_Multihilo_Sync implements Runnable {
	int entradasDisponibles = 100;
	static int entradasVendidas = 0;

	synchronized public void reservaEntrada(String nombre, int entradas) {
		// public void reservaEntrada (String nombre, int entradas) {
		if (entradas <= entradasDisponibles) {
			System.out.println(entradas + " reservadas para " + nombre);
			entradasDisponibles = entradasDisponibles - entradas;
			entradasVendidas = entradasVendidas + entradas;
		} else {
			System.out.println("No quedan entradas");
		}
	}

	public void run() {
		String nombre = Thread.currentThread().getName();
		int entradas = (int) (Math.random() * 10 + 1);
		reservaEntrada(nombre, entradas);
	}

	public static void main(String[] args) {
		PSP_Multihilo_Sync s = new PSP_Multihilo_Sync();
		Thread t;
		for (int i = 0; i < 100; i++) {
			t = new Thread(s);
			t.setName("Cliente " + (i + 1));
			t.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Pausa para dejar que acaben todos los threads
		System.out.println("Total entradas vendidas: " + entradasVendidas);
	}

}
