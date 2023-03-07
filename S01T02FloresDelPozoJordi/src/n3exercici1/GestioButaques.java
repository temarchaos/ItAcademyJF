package n3exercici1;

import java.util.ArrayList;

public class GestioButaques {
	ArrayList<Butaca> butaques;
	
	public GestioButaques() {
		butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}
	
	public void afegirButaca(Butaca butaca)  throws ExcepcioButacaOcupada{
		int butacaValida = cercarButaca(butaca.getFila(), butaca.getSeient());
		if (butacaValida != -1) {
			throw new ExcepcioButacaOcupada("La butaca introduïda està ocupada");
		}else {
			butaques.add(butaca);			
		}
	}
	
	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure{
		int butacaValida = cercarButaca(fila, seient);
		if (butacaValida == -1) {
			throw new ExcepcioButacaLliure("La butaca introduïda està lliure");
		}else {
			butaques.remove(butacaValida);			
		}
	}
	
	public int cercarButaca(int fila, int seient) {
		for (int i = 0; i < butaques.size(); i++) {
			if (butaques.get(i).equals(fila, seient)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public ArrayList<Butaca> cercarButaquesPersona(String persona){
		ArrayList<Butaca> butaquesPersona = new ArrayList<Butaca>();
		
		for (int i = 0; i < butaques.size(); i++) {
			if (butaques.get(i).getPersona().equals(persona)) {
				butaquesPersona.add(butaques.get(i));
			}
		}
		
		return butaquesPersona;
	}
}
