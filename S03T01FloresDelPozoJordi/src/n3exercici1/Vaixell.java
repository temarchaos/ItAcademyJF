package n3exercici1;

public class Vaixell implements Vehicle{

	@Override
	public void arrencar() {
		System.out.println("arrencar -> Vaixell");
	}

	@Override
	public void accelerar() {
		System.out.println("accelerar -> Vaixell");
	}

	@Override
	public void frenar() {
		System.out.println("frenar -> Vaixell");
	}
}
