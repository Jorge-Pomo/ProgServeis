package t4;

import java.io.Serializable;

public class Persona implements Serializable{
	
	// Atributs
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String edad;
	
	// Constructors
	public Persona() {super();}
	public Persona(String nombre, String apellidos, String fechaNacimiento, String edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
	}

	// Getters Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
			
}
