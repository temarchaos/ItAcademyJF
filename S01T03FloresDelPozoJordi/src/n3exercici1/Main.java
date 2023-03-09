package n3exercici1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static final String SEPARADOR = ",";
	static ArrayList<Persona> persones = new ArrayList<Persona>();
	static Scanner scanner;
	
	public static void main(String[] args) {
		llegirArxiuCSV();
		menu();
	}
	
	public static void menu() {
		scanner = new Scanner(System.in);
		
		boolean sortir = false;
		int opcio;
		
		while(!sortir){
			System.out.println("1.- Introduir persona");
			System.out.println("2.- Mostrar les persones ordenades per nom (A-Z)");
			System.out.println("3.- Mostrar les persones ordenades per nom (Z-A)");
			System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z)");
			System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A)");
			System.out.println("6.- Mostrar les persones ordenades per DNI (1-9)");
			System.out.println("7.- Mostrar les persones ordenades per DNI (9-1)");
			System.out.println("0.- Sortir");
			
			try {
				opcio = scanner.nextInt();
				
				switch(opcio){
					case 1:
						System.out.println("Escrigui el nom");
						String nom = scanner.next();
						System.out.println("Escrigui el cognom");
						String cognom = scanner.nextLine();
						if (cognom.isEmpty()) {
							cognom = scanner.nextLine();
						}
						System.out.println("Escrigui el DNI");
						String DNI = scanner.next();
						introduirPersona(nom, cognom, DNI);
						
						break;
					case 2:
						ordenarPerNom();
						mostrarPersones();
						
						break;
					case 3:
						ordenarPerNomReverse();
						mostrarPersones();
						
						break;
					case 4:
						ordenarPerCognom();
						mostrarPersones();
						
						break;
					case 5:
						ordenarPerCognomReverse();
						mostrarPersones();
						
						break;
					case 6:
						ordenarPerDNI();
						mostrarPersones();
						
						break;
					case 7:
						ordenarPerDNIReverse();
						mostrarPersones();
						
						break;
					default:
						System.out.println("Només números entre 0 i 7");
				}
			} catch(InputMismatchException e) {
				System.out.println("Has d'introduir un número");
			}
		}
	}
	
	// Case 1
	public static void introduirPersona(String nom, String cognom, String DNI) {
		Persona p = new Persona(nom, cognom, DNI);
		persones.add(p);
	}
	
	// Case 2
	public static void ordenarPerNom() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.nom.compareTo(p2.nom);
			}
		});
	}
	
	// Case 3
	public static void ordenarPerNomReverse() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.nom.compareTo(p2.nom);
			}
		});
		
		Collections.reverse(persones);
	}
	
	// Case 4
	public static void ordenarPerCognom() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.cognom.compareTo(p2.cognom);
			}
		});
	}
	
	// Case 5
	public static void ordenarPerCognomReverse() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.cognom.compareTo(p2.cognom);
			}
		});
		
		Collections.reverse(persones);
	}
	
	// Case 6
	public static void ordenarPerDNI() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.DNI.compareTo(p2.DNI);
			}
		});
	}
	
	// Case 7
	public static void ordenarPerDNIReverse() {
		Collections.sort(persones, new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.DNI.compareTo(p2.DNI);
			}
		});
		
		Collections.reverse(persones);
	}
	
	public static void mostrarPersones() {
		System.out.println("____Nom____	______Cognom______	____NIF____\n");
		for(Persona persona:persones) {
			System.out.println(persona.toString() + "\n");
		}
	}
	
	public static void llegirArxiuCSV() {
		File arxiu = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			 arxiu = new File("TestCSV - Personas.csv");
			 fr = new FileReader(arxiu);
			 br = new BufferedReader(fr);
			 
			 String linia;
			 while((linia = br.readLine()) != null) {
				 String[] data = linia.split(SEPARADOR);
				 Persona p = new Persona(data[0], data[1], data[2]);
				 persones.add(p);
			 }
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e){ 
				System.out.println(e.getMessage());
			}
		}
	}

}
