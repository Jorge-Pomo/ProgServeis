package NeoHelp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class CalcularProbabilidadImpacto {

	public static void main(String[] args) {
		String nombreNEO = args[0];
		double posicionNEO = Double.parseDouble(args[1]);
		double velocidadNEO = Double.parseDouble(args[2]);

		// Calculo
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		// Escribir en txt
		guardarProbabilidad(resultado, nombreNEO);
		
		double formatResu = (double)Math.round(resultado * 100d) / 100d;
		
		if(formatResu >= 10) {
			System.err.println("¡Alerta mundial! Alta probabilidad de impacto por un asteroide!!!");
		}else {
			System.out.println("Solo hay " + formatResu + "% de probabilidad de un impacto, no hay que preocuparse");
		}
	}
	
	// Guardar resultat
	private static boolean guardarProbabilidad(double resuProbabilidad, String nombre) {
		boolean resu = false;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\NeoHelp\\Arxius\\resultadoProbabilidad\\" + nombre));
			bw.write("" + resuProbabilidad);
		
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resu;
	}

}
