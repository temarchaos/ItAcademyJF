package n1exercici2;

public class Main {

	public static void main(String[] args) {
		Persona p = new Persona("Jordi", "Flores", 28);
		
		GenericMethods.imprimirGenerics(p, "hola", 5);
		GenericMethods.imprimirGenerics("hola", p, 5);
		GenericMethods.imprimirGenerics(5, "hola", p);
	}
}
