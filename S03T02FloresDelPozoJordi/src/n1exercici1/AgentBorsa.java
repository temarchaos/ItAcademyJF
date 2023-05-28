package n1exercici1;

import java.util.ArrayList;
import java.util.List;

public class AgentBorsa implements Observable{
	
	List<Observer> agencies;
	double valorActual;
	
	public AgentBorsa() {
		agencies = new ArrayList<Observer>();
	}

	@Override
	public void afegirObserver(Observer observer) {
		agencies.add(observer);
		
	}

	@Override
	public void eliminarObserver(Observer observer) {
		agencies.remove(observer);
		
	}

	@Override
	public void notificarObservers(double valorActual) {
		for	(Observer agencia : agencies) {
			agencia.actualitzar(valorActual);
		}
	}

	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
		notificarObservers(valorActual);
	}
}