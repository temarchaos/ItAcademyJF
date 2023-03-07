package n1exercici1;

public class Corda extends Instrument {

	public Corda(String nom, double preu) {
		super(nom, preu);
		
	}

	@Override
	public void tocar() {
		System.out.println("Està sonant un instrument de corda");
	}
}
