package n1exercici1;

public class Main {

	public static void main(String[] args) {
		AgentBorsa agent = new AgentBorsa();
		
		AgenciaBorsa agencia1 = new AgenciaBorsa("Agencia 1");
		AgenciaBorsa agencia2 = new AgenciaBorsa("Agencia 2");
		AgenciaBorsa agencia3 = new AgenciaBorsa("Agencia 3");
		
		agent.afegirObserver(agencia1);
		agent.afegirObserver(agencia2);
		agent.afegirObserver(agencia3);
		
		agent.setValorActual(3);
		agent.setValorActual(-1);
	}
}
