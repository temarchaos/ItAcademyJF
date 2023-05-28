package n1exercici1;

public class AgenciaBorsa implements Observer{
	
	String nom;
	
	public AgenciaBorsa(String nom){
		this.nom = nom;
	}
	
	void notificacio() {
		System.out.println(nom + " ha sigut notificat");
	}

	@Override
	public void actualitzar(double valorActual) {
		System.out.println("[" + nom + "] Canvi en la borsa: " + valorActual);
	}
}
