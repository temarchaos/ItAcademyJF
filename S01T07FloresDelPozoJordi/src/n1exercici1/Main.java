package n1exercici1;

public class Main {

	public static void main(String[] args) {
		Treballador t1 = new Treballador("Jordi", "Flores", 7);
		System.out.println(t1.toString() + ", " + t1.calcularSou(60));
		
		Treballador t2 = new TreballadorOnline("Jordi", "Flores", 7);
		System.out.println(t2.toString() + ", " + t2.calcularSou(60));
		
		Treballador t3 = new TreballadorPresencial("Jordi", "Flores", 7);
		System.out.println(t3.toString() + ", " + t3.calcularSou(60));
	}

}
