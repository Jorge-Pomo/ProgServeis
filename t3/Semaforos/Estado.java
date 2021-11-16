package t3.Semaforos;

public class Estado {
	
	// Atributos
	private int estadoSemaforo;
	
	// Controladores
	public Estado() {
	
	}
	public Estado(int estadoSemaforo) {
		this.estadoSemaforo = estadoSemaforo;
	}
	
	// Getters && Setters
	public int getEstadoSemaforo() {
		return estadoSemaforo;
	}

	public void setEstadoSemaforo(int estadoSemaforo) {
		this.estadoSemaforo = estadoSemaforo;
	}

}
