package n1exercici2;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Treballador t1 = new Treballador("Jordi", "Flores", 7);
		System.out.println(t1.toString() + ", " + t1.calcularSou(60));
		
		Treballador t2 = new TreballadorOnline("Jordi", "Flores", 7);
		System.out.println(t2.toString() + ", " + t2.calcularSou(60));
		
		System.out.println(((TreballadorOnline) t2).getTarifa());
		
		Treballador t3 = new TreballadorPresencial("Jordi", "Flores", 7);
		System.out.println(t3.toString() + ", " + t3.calcularSou(60));
		
		System.out.println(((TreballadorPresencial) t3).getBenzina());
	}

}
