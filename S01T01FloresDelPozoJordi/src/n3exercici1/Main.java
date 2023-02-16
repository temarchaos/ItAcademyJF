package n3exercici1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Redactor> redactorList = new ArrayList<Redactor>();
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
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
		                   
		                	 break;
		                 case 4:
		                	 System.out.println("Opció 4 seleccionada");
			                   
		                	 mostrarRedactors();
		                	 eliminarNoticia();
		                	 break;
		                 case 5:
		                	 System.out.println("Opció 5 seleccionada");
			                   
		                	 mostrarNoticies();
			                   
		                	 break;
		                 case 6:
			                   System.out.println("Opció 6 seleccionada");
			                   break;
		                 case 7:
			                   System.out.println("Opció 7 seleccionada");
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
	
	public static void mostrarRedactors() {
		int index = 1;
		for (Redactor redactor:redactorList) {
        	System.out.println(index + ". " + redactor.nom + ", " + redactor.DNI);
        	index++;
        }
	}
	
	public static void mostrarNoticies() {
		for (Redactor redactor:redactorList) {
       		System.out.println(redactor.nom + ", " + redactor.DNI);
       		for (Noticia noticia:redactor.noticiaList) {
       			System.out.println("- " + noticia.titular + ", " + noticia.text);
       		}
        }
	}
	
	public static void mostrarNoticiesRedactor(int index) {
		int indexN = 1;
		Redactor redactorSeleccionat = redactorList.get(index-1);
		for (Noticia noticia:redactorSeleccionat.noticiaList){
			System.out.println(indexN + ". " + noticia.titular + ", " + noticia.text);
		}
	}
	
	public static void mostrarPreuNoticia() {
		
	}
	
	public static void mostrarPuntuacioNoticia() {
		
	}
	
	public static void introduirRedactor() {
		System.out.println("Escrigui el nom del redactor");
		String nom = scanner.next();
		System.out.println("Escrigui el dni del redactor");
		String dni = scanner.next();
		
		Redactor newRedactor = new Redactor(nom, dni);
		redactorList.add(newRedactor);
	}
	
	public static void eliminarRedactor() {
		System.out.println("Escrigui la posició del redactor que vol eliminar");
		int index = scanner.nextInt();
		
		redactorList.remove(index-1);
	}
	
	public static void introduirNoticia() {
		
		System.out.println("Escrigui la posició del redactor que vol introduir-li una notícia");
		int index = scanner.nextInt();
		
		Redactor redactorSeleccionat = redactorList.get(index-1);
		
		System.out.println("Escrigui el titular de la notícia");
		String titular = scanner.next();
		
		System.out.println("Escrigui el tipus de notícia que vol introduir");
		
		System.out.println("- Futbol");
		System.out.println("- Basquet");
		System.out.println("- Tenis");
		System.out.println("- F1");
		System.out.println("- Motociclisme");
		
		boolean noticiaValida = false;
		
		while(!noticiaValida) {
			String tipusNoticia = scanner.next();
			
			if (tipusNoticia.equals("Futbol")) {
				Futbol newNoticiaFutbol = new Futbol(titular);
				redactorSeleccionat.noticiaList.add(newNoticiaFutbol);
				noticiaValida = true;
			}else if (tipusNoticia.equals("Basquet")) {
				Basquet newNoticiaBasquet = new Basquet(titular);
				redactorSeleccionat.noticiaList.add(newNoticiaBasquet);
				noticiaValida = true;
			}else if (tipusNoticia.equals("Tenis")) {
				Tenis newNoticiaTenis = new Tenis(titular);
				redactorSeleccionat.noticiaList.add(newNoticiaTenis);
				noticiaValida = true;
			}else if (tipusNoticia.equals("F1")) {
				F1 newNoticiaF1 = new F1(titular);
				redactorSeleccionat.noticiaList.add(newNoticiaF1);
				noticiaValida = true;
			}else if (tipusNoticia.equals("Motociclisme")) {
				Motociclisme newNoticiaMotociclisme = new Motociclisme(titular);
				redactorSeleccionat.noticiaList.add(newNoticiaMotociclisme);
				noticiaValida = true;
			}else {
				System.out.println("Tipus de notíca incorrecta. Escrigui un tipus de notícia vàlida");
			}
		}	
	}
	
	public static void eliminarNoticia() {
		System.out.println("Escrigui la posició del redactor que vol eliminar-li una notícia");
		int index = scanner.nextInt();
		
		mostrarNoticiesRedactor(index-1);
	}
}

class Redactor {
	
	String nom;
	final String DNI;
	static double sou = 1500;
	List<Noticia> noticiaList = new ArrayList<>();
	
	public Redactor(String nom, String dni) {
		super();
		this.nom = nom;
		this.DNI = dni;
	}
}

abstract class Noticia {
	
	String titular;
	String text;
	int puntuacio;
	double preu;
	
	public Noticia(String titular) {
		super();
		this.titular = titular;
		this.text = "";
	}
	
	public abstract double calcularPreuNoticia();
	public abstract int calcularPuntuacioNoticia();
}

class Futbol extends Noticia{

	String competicio;
	String club;
	String jugador;
	
	public Futbol(String titular) {
		super(titular);
		
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
}

class Basquet extends Noticia {

	String competicio;
	String club;
	
	public Basquet(String titular) {
		super(titular);
		
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 250;
		
		if (competicio.equals("Eurolliga")) {
			preuTotal += 75;
		}		
		if (club.equals("Barça") || club.equals("Madrid")) {
			preuTotal += 75;
		}

		return preuTotal;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (competicio.equals("Eurolliga")){
			puntuacioTotal += 3;
		}else if (competicio.equals("ACB")) {
			puntuacioTotal += 2;
		}
		if (club.equals("Barça") || club.equals("Madrid")) {
			puntuacioTotal += 1;
		}
		
		return puntuacioTotal;
	}
}

class Tenis extends Noticia {

	String competicio;
	String tenista;
	
	public Tenis(String titular) {
		super(titular);
		
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 150;
		
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic")) {
			preuTotal += 100;
		}		

		return preuTotal;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic")) {
			puntuacioTotal += 3;
		}
		
		return puntuacioTotal;
	}
}

class F1 extends Noticia {

	String escuderia;
	
	public F1(String titular) {
		super(titular);
		
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 100;
		
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes")) {
			preuTotal += 50;
		}		

		return preuTotal;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 4;
		
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes")) {
			puntuacioTotal += 2;
		}
		
		return puntuacioTotal;
	}
}

class Motociclisme extends Noticia {

	String equip;
	
	public Motociclisme(String titular) {
		super(titular);
		
	}

	@Override
	public double calcularPreuNoticia() {
		double preuTotal = 100;
		
		if (equip.equals("Honda") || equip.equals("Yamaha")) {
			preuTotal += 50;
		}		

		return preuTotal;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioTotal = 3;
		
		if (equip.equals("Honda") || equip.equals("Yamaha")) {
			puntuacioTotal += 3;
		}
		
		return puntuacioTotal;
	}
	
}
