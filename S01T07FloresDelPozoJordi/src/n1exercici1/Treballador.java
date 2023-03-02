package n1exercici1;

public class Treballador {
	private String nom;
	private String cognom;
	private double preuXHora;
	
	public Treballador(String nom, String cognom, double preuXHora) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.preuXHora = preuXHora;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public double getPreuXHora() {
		return preuXHora;
	}

	public void setPreuXHora(double preuXHora) {
		this.preuXHora = preuXHora;
	}
	
	@Override
	public String toString() {
		return "Treballador [nom=" + nom + ", cognom=" + cognom + ", preuXHora=" + preuXHora + "]";
	}

	public double calcularSou(double horesTreballades) {
		double resultat = horesTreballades * preuXHora;
		return resultat;
	}
}
