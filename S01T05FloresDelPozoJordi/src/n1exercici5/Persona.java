package n1exercici5;

import java.io.Serializable;

public class Persona implements Serializable{
	String dni;
	String nom;
	int edad;
	
	public Persona(String dni, String nom, int edad) {
		this.dni = dni;
		this.nom = nom;
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nom=" + nom + ", edad=" + edad + "]";
	}
}
