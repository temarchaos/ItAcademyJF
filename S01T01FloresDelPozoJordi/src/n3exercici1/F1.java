package n3exercici1;

class F1 extends Noticia {

	String escuderia;
	
	public F1(String titular) {
		super(titular);
		
		this.escuderia = "";
	}
	
	public F1(String titular, String escuderia) {
		super(titular);
		
		this.escuderia = escuderia;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes")) {
			puntuacioTotal += 2;
		}
		
		return puntuacioTotal;
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 100;
		
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes")) {
			preuTotal += 50;
		}		

		return preuTotal;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
}
