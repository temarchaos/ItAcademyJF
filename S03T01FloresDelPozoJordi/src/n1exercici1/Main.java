package n1exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Undo undo = Undo.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		boolean sortir = false;
		String opcio;
		
		while (!sortir) {
			System.out.println("Escriu una d'aquestes opcions (add, remove, clear, history, exit): ");
			
			try {
				opcio = scanner.nextLine();
				
				switch(opcio){
					case "add":
						System.out.println("Escriu una comanda: ");
						String command = scanner.nextLine();
						undo.addCommand(command);
						break;
					case "remove":
						undo.removeCommand();
						break;
					case "clear":
						undo.clearHistory();
						break;
					case "history":
						undo.printHistory();
						break;
					case "exit":
						sortir = true;
						break;
					default:
						System.out.println("Has d'introduir una opció");
				}
			}catch (InputMismatchException e) {
			   System.out.println("Has d'introduir una opció");
			   scanner.nextLine();
		    }
		}
		
		scanner.close();
	}

}
