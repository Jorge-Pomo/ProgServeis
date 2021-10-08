package EJ_t2;

public class LaanzarCalculadora {

	public void ejecutar(String ruta) {
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String ruta = "C:\\Windows\\System32\\calc.exe";
		LaanzarCalculadora lc = new LaanzarCalculadora();
		lc.ejecutar(ruta);
		System.out.println("Finalizado");

	}

}
