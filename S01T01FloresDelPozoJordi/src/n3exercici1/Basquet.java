package n3exercici1;

class Basquet extends Noticia {

	String competicio;
	String club;
	
	public Basquet(String titular) {
		super(titular);
		
		this.competicio = "";
		this.club = "";
	}
	
	public Basquet(String titular, String competicio, String club) {
		super(titular);
		
		this.competicio = competicio;
		this.club = club;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (competicio.equals("Eurolliga")){
			puntuacioTotal += 3;
		}else if (competicio.equals("ACB")) {
			puntuacioTotal += 2;
		}
		if (club.equals("Barça") || club.equals("Madrid")) {
			puntuacioTotal += 1;
		}
		
		return puntuacioTotal;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 250;
		
		if (competicio.equals("Eurolliga")) {
			preuTotal += 75;
		}		
		if (club.equals("Barça") || club.equals("Madrid")) {
			preuTotal += 75;
		}

		return preuTotal;
	}

	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
}
