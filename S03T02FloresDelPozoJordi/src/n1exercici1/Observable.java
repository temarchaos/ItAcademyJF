package n1exercici1;

public interface Observable {
	void afegirObserver(Observer observer);
	void eliminarObserver(Observer observer);
	void notificarObservers(double valorActual);
}
