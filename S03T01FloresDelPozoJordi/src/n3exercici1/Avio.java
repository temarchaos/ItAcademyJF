package n3exercici1;

public class Avio implements Vehicle{

	@Override
	public void arrencar() {
		System.out.println("arrencar -> Avio");
	}

	@Override
	public void accelerar() {
		System.out.println("accelerar -> Avio");
	}

	@Override
	public void frenar() {
		System.out.println("frenar -> Avio");
	}
}
