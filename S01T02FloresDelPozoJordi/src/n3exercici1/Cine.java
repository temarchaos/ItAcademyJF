package n3exercici1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cine {
	int files;
	int seients;
	GestioButaques gb;
	static Scanner scanner;
	
	public Cine() {
		gb = new GestioButaques();
		demanarDadesInicials(14,20);
	}
	
	public void iniciar() {
		scanner = new Scanner(System.in);
		int fila;
		int seient;
		String persona;
		boolean sortir = false;
		
		while(!sortir){
			System.out.println("1.- Mostrar totes les butaques reservades.");
	        System.out.println("2.- Mostrar les butaques reservades per una persona.");
	        System.out.println("3.- Reservar una butaca.");
	        System.out.println("4.- Anul·lar la reserva d’una butaca.");
	        System.out.println("5.- Anul·lar totes les reserves d’una persona.");
	        System.out.println("0.- Sortir.");
	        
			try {
				int opcio = menu();
				
				switch(opcio){
					case 1:
						mostrarButaques();
						break;
					case 2:
						System.out.println("Escrigui la persona");
						persona = scanner.nextLine();
						if (persona.isEmpty()) {
							persona = scanner.nextLine();
						}
						mostrarButaquesPersona(persona);
						break;
					case 3:
						System.out.println("Escrigui la fila");
						fila = scanner.nextInt();
						System.out.println("Escrigui el seient");
						seient = scanner.nextInt();
						System.out.println("Escrigui la persona");
						persona = scanner.nextLine();
						if (persona.isEmpty()) {
							persona = scanner.nextLine();
						}
						reservarButaca(fila, seient, persona);
						break;
					case 4:
						System.out.println("Escrigui la fila");
						fila = scanner.nextInt();
						System.out.println("Escrigui el seient");
						seient = scanner.nextInt();
						anularReserva(fila, seient);
						break;
					case 5:
						System.out.println("Escrigui la persona");
						persona = scanner.nextLine();
						if (persona.isEmpty()) {
							persona = scanner.nextLine();
						}
						anularReservaPersona(persona);
						break;
					case 0:
						sortir = true;
						break;
					default:
						System.out.println("Només números entre 0 i 5");
				}			
			}catch(InputMismatchException e) {
				System.out.println("Has d'introduir un número");
			}
		}
		scanner.close();
	}
	
	public int menu() {
		int opcio = scanner.nextInt();
		
		return opcio;
	}
	
	public void mostrarButaques() {
		for(Butaca butaca:gb.getButaques()) {
			System.out.println(butaca.toString());
		}
	}
	
	public void mostrarButaquesPersona(String persona) {
		for(Butaca butaca:gb.getButaques()) {
			if (butaca.persona.equals(persona)) {
				System.out.println(butaca.toString());				
			}
		}
	}
	
	public void reservarButaca(int fila, int seient, String persona) {
		try {
			introduirFila(fila);
			introduirSeient(seient);
			introduirPersona(persona);
			
			Butaca butaca = new Butaca(fila, seient, persona);
			try {
				gb.afegirButaca(butaca);
			} catch (ExcepcioButacaOcupada e) {
				System.out.println(e.getMessage());
			}
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void anularReserva(int fila, int seient) {
		try {
			introduirFila(fila);
			introduirSeient(seient);
			
			try {
				gb.eliminarButaca(fila, seient);
			} catch (ExcepcioButacaLliure e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void anularReservaPersona(String persona) {
		try {
			introduirPersona(persona);
			
			ArrayList<Butaca> butaquesPersona = gb.cercarButaquesPersona(persona);
			for (int i = 0; i < butaquesPersona.size(); i++) {
				try {
					gb.eliminarButaca(butaquesPersona.get(i).getFila(), butaquesPersona.get(i).getSeient());
				} catch (ExcepcioButacaLliure e) {
					System.out.println(e.getMessage());
				}
			}
			
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean introduirPersona(String persona) throws ExcepcioNomPersonaIncorrecte{
		if (persona.matches(".*[0-9].*")) {
			throw new ExcepcioNomPersonaIncorrecte("La persona introduïda no pot contenir números");
		}
		
		return true;
	}
	
	public void demanarDadesInicials(int files, int seients) {
		this.files = files;
		this.seients = seients;
	}
	
	public int introduirFila(int fila) throws ExcepcioFilaIncorrecta{
		if (fila < 1 || fila > files) {
			throw new ExcepcioFilaIncorrecta("La fila introduïda és incorrecta");
		}
		
		return fila;
	}
	
	public int introduirSeient(int seient) throws ExcepcioSeientIncorrecte{
		if (seient < 1 || seient > seients) {
			throw new ExcepcioSeientIncorrecte("El seient introduït és incorrecte");
		}
		
		return seient;
	}
}
