package n1exercici2;

public class TreballadorOnline extends Treballador{
	
	final double TARIFA_INTERNET = 50;
	
	public TreballadorOnline(String nom, String cognom, float preuXHora) {
		super(nom, cognom, preuXHora);
		
	}
	
	@Override
	public double calcularSou(double horesTreballades) {
		double resultat = (horesTreballades * getPreuXHora()) + TARIFA_INTERNET;
		return resultat;
	}
	
	@Deprecated
	public double getTarifa() {
		return TARIFA_INTERNET;
	}
}
