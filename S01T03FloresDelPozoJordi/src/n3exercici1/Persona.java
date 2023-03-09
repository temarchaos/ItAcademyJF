package n3exercici1;

public class Persona {
	String nom;
	String cognom;
	final String DNI;
	
	public Persona(String nom, String cognom, String DNI) {
		this.nom = nom;
		this.cognom = cognom;
		this.DNI = DNI;
	}

	@Override
	public String toString() {
		return nom + "		" + cognom + "	" + DNI;
	}
}
