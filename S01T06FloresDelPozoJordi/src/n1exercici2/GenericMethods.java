package n1exercici2;

public class GenericMethods {
	public static <T, U, V> void imprimirGenerics(T arg1, U arg2, V arg3) {
		System.out.println(arg1.toString() + ", " + arg2.toString() + ", " + arg3.toString());
	}
}
