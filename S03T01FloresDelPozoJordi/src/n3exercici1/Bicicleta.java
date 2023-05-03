package n3exercici1;

public class Bicicleta implements Vehicle{

	@Override
	public void arrencar() {
		System.out.println("arrencar -> Bicicleta");
	}

	@Override
	public void accelerar() {
		System.out.println("accelerar -> Bicicleta");
	}

	@Override
	public void frenar() {
		System.out.println("frenar -> Bicicleta");
	}
}
