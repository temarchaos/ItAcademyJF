package n1exercici1;

public class TreballadorPresencial extends Treballador{

	static double benzina = 200;
	
	public TreballadorPresencial(String nom, String cognom, float preuXHora) {
		super(nom, cognom, preuXHora);
		
	}

	@Override
	public double calcularSou(double horesTreballades) {
		double resultat = (horesTreballades * getPreuXHora()) + benzina;
		return resultat;
	}
}
