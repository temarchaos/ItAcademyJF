package n3exercici1;

class Futbol extends Noticia{

	String competicio;
	String club;
	String jugador;
	
	public Futbol(String titular) {
		super(titular);
		
		this.competicio = "";
		this.club = "";
		this.jugador = "";
	}
	
	public Futbol(String titular, String competicio, String club, String jugador) {
		super(titular);
		
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 5;
		
		if (competicio.equals("Lliga de Campions")){
			puntuacioTotal += 3;
		}else if (competicio.equals("Lliga")) {
			puntuacioTotal += 2;
		}
		if (club.equals("Barça") || club.equals("Madrid")) {
			puntuacioTotal += 1;
		}
		if (jugador.equals("Ferran Torres") || jugador.equals("Benzema")) {
			puntuacioTotal += 1;
		}
		
		return puntuacioTotal;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 300;
		
		if (competicio.equals("Lliga de Campions")) {
			preuTotal += 100;
		}		
		if (club.equals("Barça") || club.equals("Madrid")) {
			preuTotal += 100;
		}
		if (jugador.equals("Ferran Torres") || jugador.equals("Benzema")) {
			preuTotal += 50;
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
}
