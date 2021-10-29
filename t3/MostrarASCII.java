package t3;

public class MostrarASCII implements Runnable {

	private int tipo;

	public MostrarASCII() {

	}

	public MostrarASCII(int tipo) {
		this.tipo = tipo;
	}

	public static void main(String[] args) {
		MostrarASCII mImpar = new MostrarASCII(1);
		MostrarASCII mPar = new MostrarASCII(2);

		Thread hilo1 = new Thread(mImpar);
		Thread hilo2 = new Thread(mPar);

		hilo1.start();
		hilo2.start();

	}

	@Override
	public void run() {
		if (this.tipo == 1) {
			for (int i = 1; i <= 255; i = i + 2) {
				char convertedChar = (char)i;
				System.out.println(convertedChar);
			}
		} else {
			for (int i = 0; i < 255; i = i + 2) {
				char convertedChar = (char)i;
				System.err.println(convertedChar);
			}
		}

	}

}
