package n3exercici1;

public class Butaca {
	int fila;
	int seient;
	String persona;
	
	public Butaca(int fila, int seient, String persona) {
		this.fila = fila;
		this.seient = seient;
		this.persona = persona;
	}

	public int getFila() {
		return fila;
	}

	public int getSeient() {
		return seient;
	}

	public String getPersona() {
		return persona;
	}

	public boolean equals(int fila, int seient) {
		return fila == this.fila && seient == this.seient;
	}

	@Override
	public String toString() {
		return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + persona;
	}
}
