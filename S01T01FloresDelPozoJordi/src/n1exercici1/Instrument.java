package n1exercici1;

public abstract class Instrument {
	String nom;
	double preu;
	
	public Instrument(String nom, double preu) {
		super();
		this.nom = nom;
		this.preu = preu;
	}

	public abstract void tocar();
}