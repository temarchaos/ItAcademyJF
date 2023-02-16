package n2exercici1;

public class Main {
	public static void main(String[] args) {
		Smartphone newSmartphone = new Smartphone();
		
		newSmartphone.trucar("931987987");
		newSmartphone.fotografiar();
		newSmartphone.alarma();
	}
}

class Telefon {
	String marca;
	String model;
	
	public void trucar(String num) {
		System.out.println("S’està trucant a " + num);
	}
}

interface Camera {
	public void fotografiar();
}

interface Rellotge {
	public void alarma();
}

class Smartphone extends Telefon implements Camera, Rellotge{

	@Override
	public void alarma() {
		System.out.println("Està sonant l’alarma");
		
	}

	@Override
	public void fotografiar() {
		System.out.println("S’està fent una foto");
		
	}
	
}
