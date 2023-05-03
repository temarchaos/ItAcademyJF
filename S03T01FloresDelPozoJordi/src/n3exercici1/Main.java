package n3exercici1;

public class Main {

	public static void main(String[] args) {
		
		// Cotxe Commands
		Vehicle newCotxe = new Cotxe();
		System.out.println("Un cotxe ha entrat al pàrquing");
		
		Command cotxeArrencarCommand = new ArrencarCommand(newCotxe);
		cotxeArrencarCommand.execute();
		
		Command cotxeAccelerarCommand = new AccelerarCommand(newCotxe);
		cotxeAccelerarCommand.execute();
		
		Command cotxeFrenarCommand = new FrenarCommand(newCotxe);
		cotxeFrenarCommand.execute();
		
		// Bicicleta Commands
		Vehicle newBicicleta = new Bicicleta();
		System.out.println("\nUna bicicleta ha entrat al pàrquing");
		
		Command bicicletaArrencarCommand = new ArrencarCommand(newBicicleta);
		bicicletaArrencarCommand.execute();
				
		Command bicicletaAccelerarCommand = new AccelerarCommand(newBicicleta);
		bicicletaAccelerarCommand.execute();
				
		Command bicicletaFrenarCommand = new FrenarCommand(newBicicleta);
		bicicletaFrenarCommand.execute();
		
		// Avio Commands
		Vehicle newAvio = new Avio();
		System.out.println("\nUn avió ha entrat al pàrquing");
				
		Command avioArrencarCommand = new ArrencarCommand(newAvio);
		avioArrencarCommand.execute();
						
		Command avioAccelerarCommand = new AccelerarCommand(newAvio);
		avioAccelerarCommand.execute();
						
		Command avioFrenarCommand = new FrenarCommand(newAvio);
		avioFrenarCommand.execute();
		
		// Vaixell Commands
		Vehicle newVaixell = new Vaixell();
		System.out.println("\nUn vaixell ha entrat al pàrquing");
					
		Command vaixellArrencarCommand = new ArrencarCommand(newVaixell);
		vaixellArrencarCommand.execute();
								
		Command vaixellAccelerarCommand = new AccelerarCommand(newVaixell);
		vaixellAccelerarCommand.execute();
								
		Command vaixellFrenarCommand = new FrenarCommand(newVaixell);
		vaixellFrenarCommand.execute();
	}
}