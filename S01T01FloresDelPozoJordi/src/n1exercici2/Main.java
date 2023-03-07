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