package n3exercici1;

class Motociclisme extends Noticia {

	String equip;
	
	public Motociclisme(String titular) {
		super(titular);
		
	}
	
	public Motociclisme(String titular, String equip) {
		super(titular);
		
		this.equip = equip;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 3;
		
		if (equip.equals("Honda") || equip.equals("Yamaha")) {
			puntuacioTotal += 3;
		}
		
		return puntuacioTotal;
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 100;
		
		if (equip.equals("Honda") || equip.equals("Yamaha")) {
			preuTotal += 50;
		}		

		return preuTotal;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}
}
