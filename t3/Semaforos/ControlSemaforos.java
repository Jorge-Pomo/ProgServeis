package t3.Semaforos;

public class ControlSemaforos implements Runnable {

	// Atributs
	public int estado;
	public int semaforo;

	//Main m = new Main(); 
	
	// Constructors
	public ControlSemaforos() {

	}

	public ControlSemaforos(int estado, int semaforo) {
		this.estado = estado;
		this.semaforo = semaforo;
	}

	// MEtodos
	// Semaforo 1
	public void encenderSemaforo1() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (estado == 1) {
					System.out.println("Semaforo 1 En espera");
					wait();
				}

				System.out.println("El semaforo 1 esta en verde");
				Thread.sleep(300);

				estado = 1;

				notify();
			}
		}
	}

	// Semaforo 2
	public void encenderSemaforo2() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (estado == 0) {
					System.err.println("Semaforo 2 En espera");
					wait();
				}

				System.err.println("El semaforo 2 esta en verde");
				Thread.sleep(300);
				estado = 0;
				notify();
			}
		}
	}

	// Runnable
	@Override
	public void run() {
		if (semaforo == 1) {
			try {
				encenderSemaforo1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				encenderSemaforo2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
