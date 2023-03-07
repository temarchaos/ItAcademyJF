package n3exercici1;

import java.util.ArrayList;
import java.util.List;

public class Redactor {
	
	String nom;
	final String DNI;
	static double sou = 1500;
	List<Noticia> noticiaList = new ArrayList<>();
	
	public Redactor(String nom, String dni) {
		super();
		this.nom = nom;
		this.DNI = dni;
	}

	@Override
	public String toString() {
		return "Redactor [nom=" + nom + ", DNI=" + DNI + ", noticiaList=" + noticiaList + "]";
	}
}
