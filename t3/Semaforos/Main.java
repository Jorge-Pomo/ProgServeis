package t3.Semaforos;

public class Main {
	
	public static void main(String[] args) {
		Estado es = new Estado(1);
		
		ControlSemaforos cs1 = new ControlSemaforos(es.getEstadoSemaforo(), 1);
		ControlSemaforos cs2 = new ControlSemaforos(es.getEstadoSemaforo(), 2);

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
