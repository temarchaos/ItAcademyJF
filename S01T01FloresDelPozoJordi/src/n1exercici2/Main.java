package n1exercici2;

public class Main {
	public static void main(String[] args) {
		Cotxe newCotxe = new Cotxe("C3", 100);
		System.out.println(Cotxe.MARCA + ", " + Cotxe.model + ", " + newCotxe.POTENCIA);
		
		// Com invocar un mètode static
		Cotxe.frenar();
		
		// Com invocar un mètode no static
		newCotxe.accelerar();
	}
}

class Cotxe {
	/* La diferencia entre "final static", "static" i "final", es que "var amb final static" ha de inicialitzar-se on 
	 * es declara la variable, aquesta és una constant que no pot ser modificada y no pot inicialitzar-se en
	 * el constructor. "var amb static" formarà membre de la classe però no de la instància, surt un warning si utilizes 
	 * la instancia. "var amb final no es pot modificar, actua com una constant, no et deixa fer el setter.*/
	
	static final String MARCA = "Citroen";
	static String model;
	final int POTENCIA;
	
	// Tant l'atribut model com potència es poden inicialitzar al constructor de la classe
	public Cotxe(String model, int potencia) {
		super();
		Cotxe.model = model;
		this.POTENCIA = potencia;
	}
	
	/*public Cotxe(String marca, String model, int potencia) {
		this.MARCA = marca;
		this.model = model;
		this.POTENCIA = potencia;
	}*/

	public static void frenar() {
		System.out.println("El vehicle està frenant");
	}
	
	public void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
}
