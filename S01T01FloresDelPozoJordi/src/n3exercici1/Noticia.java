package n3exercici1;

public abstract class Noticia {
	
	String titular;
	String text;
	int puntuacio;
	double preu;
	
	public Noticia(String titular) {
		super();
		this.titular = titular;
		this.text = "";
		this.puntuacio = 0;
		this.preu = 0;
	}
	
	@Override
	public String toString() {
		return "Noticia [titular=" + titular + ", text=" + text + ", puntuacio=" + puntuacio + ", preu=" + preu + "]";
	}



	public abstract int calcularPuntuacioNoticia();
	public abstract double calcularPreuNoticia();
}
