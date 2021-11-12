package t3.Semaforos;

public class Main {

	public boolean estado = true;
	
	public static void main(String[] args) {
		ControlSemaforos cs1 = new ControlSemaforos(false);
		ControlSemaforos cs2 = new ControlSemaforos(false);

		Thread semaforo1 = new Thread(cs1);
		Thread semaforo2 = new Thread(cs2);

		semaforo1.start();
		semaforo2.start();

		try {
			semaforo1.join();
			semaforo2.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
