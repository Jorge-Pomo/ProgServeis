package App;

import java.io.Serializable;

public class Contrase�a implements Serializable{

	// Atributs
	private String textoPlano;
	private String encriptada;
	
	// Constructors
	public Contrase�a() {
	}
	
	public Contrase�a(String textoPlano) {
		this.encriptada = encriptada;
	}
	
	//Getters && Setters
	public String getTextoPlano() {
		return textoPlano;
	}

	public void setTextoPlano(String textoPlano) {
		this.textoPlano = textoPlano;
	}

	public String getEncriptada() {
		return encriptada;
	}

	public void setEncriptada(String encriptada) {
		this.encriptada = encriptada;
	}
	
}
