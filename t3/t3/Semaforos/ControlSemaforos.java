package t3.Semaforos;

public class ControlSemaforos implements Runnable {

	// Atributs
	public Estado es;
	public int semaforo;

	//Main m = new Main(); 
	
	// Constructors
	public ControlSemaforos() {

	}

	public ControlSemaforos(Estado es, int semaforo) {
		this.es = es;
		this.semaforo = semaforo;
	}

	// MEtodos
	// Semaforo 1
	public void encenderSemaforo1() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (es.getEstadoSemaforo() != 0) {
					System.out.println("Semaforo 1 En espera");
					wait();
				}

				System.out.println("El semaforo 1 esta en verde");
				Thread.sleep(300);

				es.setEstadoSemaforo(1);

				notify();
			}
		}
	}

	// Semaforo 2
	public void encenderSemaforo2() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (es.getEstadoSemaforo() == 0) {
					System.err.println("Semaforo 2 En espera");
					wait();
				}

				System.err.println("El semaforo 2 esta en verde");
				Thread.sleep(300);
				es.setEstadoSemaforo(0);
				notify();
			}
		}
	}

	// Runnable
	@Override
	public void run() {
		if (semaforo == 1) {
			try {
				System.out.println("Semaforo 1");
				encenderSemaforo1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.err.println("Semaforo 2");
				encenderSemaforo2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
