package n1exercici1;

public class Main {
	// Per accés a un membre static
	static Vent newInstrument4 = new Vent("",0);
	/*static Vent newInstrument4 = initVent();
	static Vent initVent() {
		return new Vent("Oboe", 50.8);
	}*/
	
	static {
		newInstrument4.nom = "Guitarra";
		newInstrument4.preu = 200.20;
	}
			
	public static void main(String[] args) {
		// Càrrega procada per la creació de la instància
		Vent newInstrument = new Vent("Flauta", 20.15);
		System.out.println(newInstrument.nom + ", " + newInstrument.preu + "€");
		newInstrument.tocar();
		
		Corda newInstrument2 = new Corda("Violí", 40.6);
		System.out.println(newInstrument2.nom + ", " + newInstrument2.preu + "€");
		newInstrument2.tocar();
		
		Percussio newInstrument3 = new Percussio("Tambor", 100.42);
		System.out.println(newInstrument3.nom + ", " + newInstrument3.preu + "€");
		newInstrument3.tocar();
		
		System.out.println(newInstrument4.nom + ", " + newInstrument4.preu);
		newInstrument4.tocar();
	}
}

abstract class Instrument {
	String nom;
	double preu;
	
	public Instrument(String nom, double preu) {
		super();
		this.nom = nom;
		this.preu = preu;
	}

	public abstract void tocar();
}

class Vent extends Instrument {
	
	public Vent(String nom, double preu) {
		super(nom, preu);
		
	}

	@Override
	public void tocar() {
		System.out.println("Està sonant un instrument de vent");
	}
}

class Corda extends Instrument {

	public Corda(String nom, double preu) {
		super(nom, preu);
		
	}

	@Override
	public void tocar() {
		System.out.println("Està sonant un instrument de corda");
	}
}

class Percussio extends Instrument {

	public Percussio(String nom, double preu) {
		super(nom, preu);
	}
	
	@Override
	public void tocar() {
		System.out.println("Està sonant un instrument de percussió");
	}
	
}
