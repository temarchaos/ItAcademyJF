package n3exercici1;

class Tenis extends Noticia {

	String competicio;
	String tenista;
	
	public Tenis(String titular) {
		super(titular);
		
		this.competicio = "";
		this.tenista = "";
	}
	
	public Tenis (String titular, String competicio, String tenista) {
		super(titular);
		
		this.competicio = competicio;
		this.tenista = tenista;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic")) {
			puntuacioTotal += 3;
		}
		
		return puntuacioTotal;
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 150;
		
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic")) {
			preuTotal += 100;
		}		

		return preuTotal;
	}

	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getTenista() {
		return tenista;
	}

	public void setTenista(String tenista) {
		this.tenista = tenista;
	}
}
