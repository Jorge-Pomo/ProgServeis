package t3.Semaforos;

public class ControlSemaforos implements Runnable {

	// Atributs
	
	public int semaforo;

	// Constructors
	public ControlSemaforos() {

	}

	public ControlSemaforos(boolean estado, int semaforo) {
		Main.estado = estado;
		this.semaforo = semaforo;
	}

	// MEtodos
	// Semaforo 1
	public void encenderSemaforo1() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (estado == false)
					wait();
				
				System.out.println("El semaforo 1 esta en verde");
				Thread.sleep(3000);
				
				estado = false;
				
				notify();
			}
		}
	}

	// Semaforo 2
	public void encenderSemaforo2() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (estado == true) wait();
				
				System.err.println("El semaforo 2 esta en verde");
				Thread.sleep(3000);
				estado = true;
				notify();
			}
		}
	}

	// Runnable
	@Override
	public void run() {
		if (estado) {
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
