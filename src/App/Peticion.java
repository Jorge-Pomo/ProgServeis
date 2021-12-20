package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Peticion implements Runnable {
	// Atributs
	Socket socket;
	BufferedReader bfr;
	
	// Constructor
	public Peticion(Socket socket) {
		this.socket = socket;
	}

	// encriptar(String)
	// Parametres d'entrada: String amb la Contraseña
	// PAramentres d'eixida: String amb a contraseña encriptada
	// El metodo encripta una contraseña sumant-li al caracter en ASCII un número mes
	public String encriptar(String contra) {
		String resu = "";
//		if (opc.equals("1")) {
			byte[] bytes = contra.getBytes(StandardCharsets.US_ASCII);
			char[] carAscii = new char[bytes.length];
			String encriptada = "";
			for (int i = 0; i < bytes.length; i++) {
				if (bytes[i] <= 127) {
					carAscii[i] = (char) (bytes[i] + 1);
				} else {
					carAscii[i] = '*';
				}

				encriptada += carAscii[i];
			}
			resu = encriptada;
//		} else {
//			MessageDigest md;
//			try {
//				md = MessageDigest.getInstance("MD5");
//				md.update(contra.getBytes());
//				String pwd = new BigInteger(1, md.digest()).toString(16);
//				resu = pwd;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
		
		return resu;
	}

	// run()
	// Fil que es comunicara en el client
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			Contraseña c = new Contraseña("Contraseña");
			outObjeto.writeObject(c);

			System.err.println("SERVIDOR >>> Lee contraseña para la encriptación");
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contraseña cMod = (Contraseña) inObjeto.readObject();

			System.err.println("SERVIDOR >>> Realiza la encriptación");
			cMod.setEncriptada(encriptar(cMod.getTextoPlano()));

			System.err.println("SERVIDOR >>> Devuelve resultado");
			outObjeto.writeObject(cMod);

			System.err.println("SERVIDOR >>> Espera nueva peticion");

		} catch (IOException e) {

			e.printStackTrace();

			System.err.println("SERVIDOR >>> Error.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
