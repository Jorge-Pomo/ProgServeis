package NeoHelp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class CalcularProbabilidadImpacto {

	//Main
	public static void main(String[] args) {
		String nombreNEO = args[0];
		double posicionNEO = Double.parseDouble(args[1]);
		double velocidadNEO = Double.parseDouble(args[2]);

		// Calculo de probabilidad
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		// Enviem parametres a guardarProbabilidad
		if(guardarProbabilidad(resultado, nombreNEO)) {
			System.out.println("Exit en l'escriptura");
		}else {
			System.err.println("Error, l'escriptura ha fallat");
		}
		
		// Li donem format al double
		double formatResu = (double)Math.round(resultado * 100d) / 100d;
		
		// Mensaje por terminal
		if(formatResu >= 10) {
			System.err.println("¡Alerta mundial! Hay un " + formatResu + " probabilidad de impacto por un asteroide!!!");
		}else {
			System.out.println("Solo hay " + formatResu + "% de probabilidad de un impacto, no hay que preocuparse");
		}
	}
	
	// guardarProbabilidad(double, String)
	// Parametres d'entrada: un double amb la probabilitat d'impacte y un String amb el nom del NEO
	// Eixida: un boolean diguent si l'escritura a tingut exit o no.
	private static boolean guardarProbabilidad(double resuProbabilidad, String nombre) {
		boolean resu = false;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\NeoHelp\\Arxius\\resultadoProbabilidad\\" + nombre));
			bw.write("" + resuProbabilidad);
		
			resu = true;
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resu;
	}

}
