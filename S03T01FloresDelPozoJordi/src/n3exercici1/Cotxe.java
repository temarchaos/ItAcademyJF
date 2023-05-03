package n3exercici1;

public class Cotxe implements Vehicle{

	@Override
	public void arrencar() {
		System.out.println("arrencar -> Cotxe");
	}

	@Override
	public void accelerar() {
		System.out.println("accelerar -> Cotxe");
	}

	@Override
	public void frenar() {
		System.out.println("frenar -> Cotxe");
	}
}
