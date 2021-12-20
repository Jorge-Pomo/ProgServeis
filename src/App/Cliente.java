package App;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	// Main
	// Arranca el client i es cominica en el Servidor
	public static void main(String[] arg) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		String host = "localhost";
		int puerto = 1234;
		
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		
		Contrase�a c = (Contrase�a) inObjeto.readObject();
		System.out.println("CLIENTE >> Recibo del servidor: " + c.getTextoPlano() + " - " + c.getEncriptada());

		System.out.println("Dime la contrase�a:");
		String contrase�aUsuario = sc.nextLine();
		c.setTextoPlano(contrase�aUsuario);
		
//		System.out.println("que tipo de encriptaci�n quieres?");
//		System.out.println("1.- Poco segura");
//		System.out.println("2.- Muy segura");
		
//		String opc = sc.nextLine();
		
//		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(c);
		
		System.out.println("CLIENTE >> Envio al servidor: " + c.getTextoPlano() + " - " + c.getTextoPlano());
		
		Contrase�a encripted = (Contrase�a) inObjeto.readObject();
		System.out.println(encripted.getEncriptada());
		
		inObjeto.close();
		pMod.close();
		cliente.close();
	}

}
