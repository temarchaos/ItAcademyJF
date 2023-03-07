package n3exercici1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Redactor> redactorList = new ArrayList<Redactor>();
	private static Scanner scanner;
	
	public static void main(String[] args) {
		// Init
		initRedactors();
		initNoticies();
		
		scanner = new Scanner(System.in);
		boolean sortir = false;
		int opcio;
		while(!sortir){
            
	           System.out.println("1. Introduir redactor.");
	           System.out.println("2. Eliminar redactor.");
	           System.out.println("3. Introduir notícia a un redactor.");
	           System.out.println("4. Eliminar notícia (ha de demanar redactor i titular de la notícia).");
	           System.out.println("5. Mostrar totes les notícies per redactor.");
	           System.out.println("6. Calcular puntuació de la notícia.");
	           System.out.println("7. Calcular preu-notícia.");
	           System.out.println("8. Sortir");
	           
	           try {
		           opcio = scanner.nextInt();
		            
		           switch(opcio){
		           		case 1:
		           			System.out.println("Opció 1 seleccionada");
		           			
			                introduirRedactor();
			                mostrarRedactors();
		                   
			                break;
		                case 2:
			                System.out.println("Opció 2 seleccionada");
			                
			                mostrarRedactors();
			                eliminarRedactor();
			                mostrarRedactors();
			                
			                break;
		                 case 3:
		                	 System.out.println("Opció 3 seleccionada");
		                   
		                	 mostrarRedactors();
		                	 introduirNoticia();
		                	 mostrarRedactors();
		                   
		                	 break;
		                 case 4:
		                	 System.out.println("Opció 4 seleccionada");
			                   
		                	 mostrarRedactors();
		                	 eliminarNoticia();
		                	 mostrarRedactors();
		                	 
		                	 break;
		                 case 5:
		                	 System.out.println("Opció 5 seleccionada");
			                   
		                	 mostrarNoticies();
			                   
		                	 break;
		                 case 6:
			                   System.out.println("Opció 6 seleccionada");
			                   
			                   mostrarPuntuacioNoticia();
			                   
			                   break;
		                 case 7:
			                   System.out.println("Opció 7 seleccionada");
			                   
			                   mostrarPreuNoticia();
			                   
			                   break;
		                 case 8:
		                   sortir = true;
		                   break;
		                 default:
		                   System.out.println("Només números entre 1 i 8");
		           }
		   	} catch (InputMismatchException e) {
			   System.out.println("Has d'introduir un número");
			   scanner.next();
		    }
		}
	}
	
	// Init Redactors
	public static void initRedactors() {
		Redactor r1 = new Redactor("Jordi", "123");
		Redactor r2 = new Redactor("Sara", "456");
		Redactor r3 = new Redactor("Pedro", "789");
		redactorList.add(r1);
		redactorList.add(r2);
		redactorList.add(r3);
	}
	
	// Init Noticies
	public static void initNoticies() {
		
		redactorList.get(0).noticiaList.add(new Futbol("Gol de Ferran Torres del Barça a la Lliga de Campions"));
	}
	
	// Case 1
	public static void introduirRedactor() {
		System.out.println("Escrigui el nom del redactor");
		String nom = scanner.next();
		System.out.println("Escrigui el dni del redactor");
		String dni = scanner.next();
		
		Redactor newRedactor = new Redactor(nom, dni);
		redactorList.add(newRedactor);
	}
	
	// Case 2
	public static void eliminarRedactor() {
		System.out.println("Escrigui el dni del redactor que vol eliminar");
		String dni = scanner.next();
		Redactor actualRedactor = null;
		
		for (Redactor redactor:redactorList) {
			if (redactor.DNI.equals(dni)) {
				actualRedactor = redactor;
				redactorList.remove(redactor);
			}
		}
		
		if (actualRedactor == null) {
			System.out.println("No s'ha trobat cap redactor amb aquest dni");
		}
	}
	
	// Case 3
	public static void introduirNoticia() {
		
		System.out.println("Escrigui el dni del redactor que vol introduir-li una notícia");
		String dni = scanner.next();
		Redactor actualRedactor = null;
		
		for (Redactor redactor:redactorList) {
			if (redactor.DNI.equals(dni)) {
				actualRedactor = redactor;
			}
		}
		
		if (actualRedactor != null) {
			System.out.println("Escrigui el titular de la notícia");
			String titular = scanner.nextLine();
			
			if (titular.isEmpty()) {
				titular = scanner.nextLine();
			}
			
			boolean noticiaValida = false;
			int opcio;
			
			while(!noticiaValida) {
				System.out.println("Escrigui el tipus de notícia que vol introduir");
				System.out.println("1. Futbol");
				System.out.println("2. Basquet");
				System.out.println("3. Tenis");
				System.out.println("4. F1");
				System.out.println("5. Motociclisme");
				
				try {
					opcio = scanner.nextInt();
					
					switch(opcio){
						case 1:
							Futbol newNoticiaFutbol = new Futbol(titular);
							actualRedactor.noticiaList.add(newNoticiaFutbol);
							noticiaValida = true;
							break;
						case 2:
							Basquet newNoticiaBasquet = new Basquet(titular);
							actualRedactor.noticiaList.add(newNoticiaBasquet);
							noticiaValida = true;
							break;
						case 3:
							Tenis newNoticiaTenis = new Tenis(titular);
							actualRedactor.noticiaList.add(newNoticiaTenis);
							noticiaValida = true;
							break;
						case 4:
							F1 newNoticiaF1 = new F1(titular);
							actualRedactor.noticiaList.add(newNoticiaF1);
							noticiaValida = true;
							break;
						case 5:
							Motociclisme newNoticiaMotociclisme = new Motociclisme(titular);
							actualRedactor.noticiaList.add(newNoticiaMotociclisme);
							noticiaValida = true;
							break;
						default:
							System.out.println("Només números entre 1 i 5");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("Tipus de notíca incorrecta. Escrigui un tipus de notícia vàlida");
					scanner.next();
			    }
			}
		}else {
			System.out.println("No s'ha trobat cap redactor amb aquest dni");
		}
	}
	
	// Case 4
	public static void eliminarNoticia() {
		System.out.println("Escrigui el dni del redactor que vol eliminar-li una notícia");
		String dni = scanner.next();
		
		System.out.println("Escrigui el titular de la notícia que vol eliminar");
		String titular = scanner.nextLine();
		
		if (titular.isEmpty()) {
			titular = scanner.nextLine();
		}
		
		Redactor actualRedactor = null;
		Noticia actualNoticia = null;
		
		for (Redactor redactor:redactorList) {
			if (redactor.DNI.equals(dni)) {
				actualRedactor = redactor;
				for (Noticia noticia:redactor.noticiaList) {
					if (noticia.titular.equals(titular)) {
						actualNoticia = noticia;
						redactor.noticiaList.remove(noticia);
						return;
					}
				}
			}
		}
		
		if (actualRedactor == null) {
			System.out.println("No s'ha trobat cap redactor amb aquest dni");
		}
		
		if (actualNoticia == null){
			System.out.println("No s'ha trobat cap notícia amb aquest titular");
		}
	}
	
	// Case 5
	public static void mostrarNoticies() {
		System.out.println("Escrigui el dni del redactor per veure les seves notícies");
		String dni = scanner.next();
		Redactor actualRedactor = null;
		
		for (Redactor redactor:redactorList) {
			if (redactor.DNI.equals(dni)) {
				for (int i = 0; i < redactor.noticiaList.size(); i++) {
					System.out.println(redactor.noticiaList.get(i).toString());
				}
				return;
			}
        }
		
		if (actualRedactor == null) {
			System.out.println("No s'ha trobat cap redactor amb aquest dni");
		}
	}
	
	// Case 6
	public static void mostrarPuntuacioNoticia() {
		boolean noticiaValida = false;
		int opcio;
		
		while(!noticiaValida) {
			System.out.println("Escrigui el tipus de notícia que vol introduir");
			System.out.println("1. Futbol");
			System.out.println("2. Basquet");
			System.out.println("3. Tenis");
			System.out.println("4. F1");
			System.out.println("5. Motociclisme");
			
			try {
				opcio = scanner.nextInt();
				String competicio;
				String club;
				String jugador;
				String tenista;
				String escuderia;
				String equip;
				int resultat;
				
				switch(opcio){
					case 1:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el club");
						club = scanner.nextLine();
						
						if (club.isEmpty()) {
							club = scanner.nextLine();
						}
						
						System.out.println("Escrigui el jugador");
						jugador = scanner.nextLine();
						
						if (jugador.isEmpty()) {
							jugador = scanner.nextLine();
						}
						
						Futbol newNoticiaFutbol = new Futbol("", competicio, club, jugador);
						
						resultat = newNoticiaFutbol.calcularPuntuacioNoticia();
						System.out.println("Aquesta notícia de Futbol té una puntuació de: " + resultat + " punts");
						
						noticiaValida = true;
						
						break;
					case 2:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el club");
						club = scanner.nextLine();
						
						if (club.isEmpty()) {
							club = scanner.nextLine();
						}
						
						Basquet newNoticiaBasquet = new Basquet("", competicio, club);
						
						resultat = newNoticiaBasquet.calcularPuntuacioNoticia();
						System.out.println("Aquesta notícia de Basquet té una puntuació de: " + resultat + " punts");
						
						noticiaValida = true;
						
						break;
					case 3:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el tenista");
						tenista = scanner.nextLine();
						
						if (tenista.isEmpty()) {
							tenista = scanner.nextLine();
						}
						
						Tenis newNoticiaTenis = new Tenis("", competicio, tenista);
						
						resultat = newNoticiaTenis.calcularPuntuacioNoticia();
						System.out.println("Aquesta notícia de Tenis té una puntuació de: " + resultat + " punts");
						
						noticiaValida = true;
						
						break;
					case 4:
						System.out.println("Escrigui la escuderia");
						escuderia = scanner.nextLine();
						
						if (escuderia.isEmpty()) {
							escuderia = scanner.nextLine();
						}
						
						F1 newNoticiaF1 = new F1("", escuderia);
						
						resultat = newNoticiaF1.calcularPuntuacioNoticia();
						System.out.println("Aquesta notícia de F1 té una puntuació de: " + resultat + " punts");
						
						noticiaValida = true;
						
						break;
					case 5:
						System.out.println("Escrigui el equip");
						equip = scanner.nextLine();
						
						if (equip.isEmpty()) {
							equip = scanner.nextLine();
						}
						
						Motociclisme newNoticiaMotociclisme = new Motociclisme("", equip);
						
						resultat = newNoticiaMotociclisme.calcularPuntuacioNoticia();
						System.out.println("Aquesta notícia de Motociclisme té una puntuació de: " + resultat + " punts");

						noticiaValida = true;
						
						break;
					default:
						System.out.println("Només números entre 1 i 5");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Tipus de notíca incorrecta. Escrigui un tipus de notícia vàlida");
				scanner.next();
		    }
		}
	}
	
	// Case 7
	public static void mostrarPreuNoticia() {
		boolean noticiaValida = false;
		int opcio;
		
		while(!noticiaValida) {
			System.out.println("Escrigui el tipus de notícia que vol introduir");
			System.out.println("1. Futbol");
			System.out.println("2. Basquet");
			System.out.println("3. Tenis");
			System.out.println("4. F1");
			System.out.println("5. Motociclisme");
			
			try {
				opcio = scanner.nextInt();
				String competicio;
				String club;
				String jugador;
				String tenista;
				String escuderia;
				String equip;
				double resultat;
				
				switch(opcio){
					case 1:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el club");
						club = scanner.nextLine();
						
						if (club.isEmpty()) {
							club = scanner.nextLine();
						}
						
						System.out.println("Escrigui el jugador");
						jugador = scanner.nextLine();
						
						if (jugador.isEmpty()) {
							jugador = scanner.nextLine();
						}
						
						Futbol newNoticiaFutbol = new Futbol("", competicio, club, jugador);
						
						resultat = newNoticiaFutbol.calcularPreuNoticia();
						System.out.println("Aquesta notícia de Futbol té un preu de: " + resultat + "€");
						
						noticiaValida = true;
						
						break;
					case 2:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el club");
						club = scanner.nextLine();
						
						if (club.isEmpty()) {
							club = scanner.nextLine();
						}
						
						Basquet newNoticiaBasquet = new Basquet("", competicio, club);
						
						resultat = newNoticiaBasquet.calcularPreuNoticia();
						System.out.println("Aquesta notícia de Basquet té un preu de: " + resultat + "€");
						
						noticiaValida = true;
						
						break;
					case 3:
						System.out.println("Escrigui la competició");
						competicio = scanner.nextLine();
						
						if (competicio.isEmpty()) {
							competicio = scanner.nextLine();
						}
						
						System.out.println("Escrigui el tenista");
						tenista = scanner.nextLine();
						
						if (tenista.isEmpty()) {
							tenista = scanner.nextLine();
						}
						
						Tenis newNoticiaTenis = new Tenis("", competicio, tenista);
						
						resultat = newNoticiaTenis.calcularPreuNoticia();
						System.out.println("Aquesta notícia de Tenis té un preu de: " + resultat + "€");
						
						noticiaValida = true;
						
						break;
					case 4:
						System.out.println("Escrigui la escuderia");
						escuderia = scanner.nextLine();
						
						if (escuderia.isEmpty()) {
							escuderia = scanner.nextLine();
						}
						
						F1 newNoticiaF1 = new F1("", escuderia);
						
						resultat = newNoticiaF1.calcularPreuNoticia();
						System.out.println("Aquesta notícia de F1 té un preu de: " + resultat + "€");
						
						noticiaValida = true;
						
						break;
					case 5:
						System.out.println("Escrigui el equip");
						equip = scanner.nextLine();
						
						if (equip.isEmpty()) {
							equip = scanner.nextLine();
						}
						
						Motociclisme newNoticiaMotociclisme = new Motociclisme("", equip);
						
						resultat = newNoticiaMotociclisme.calcularPreuNoticia();
						System.out.println("Aquesta notícia de Motociclisme té un preu de: " + resultat + "€");

						noticiaValida = true;
						
						break;
					default:
						System.out.println("Només números entre 1 i 5");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Tipus de notíca incorrecta. Escrigui un tipus de notícia vàlida");
				scanner.next();
		    }
		}
	}
	
	public static void mostrarRedactors() {
		for (Redactor redactor:redactorList) {
        	System.out.println(redactor.toString());
        }
	}
}
