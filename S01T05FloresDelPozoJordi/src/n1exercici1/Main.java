package n1exercici1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	/* Ejecutar el java en el terminal
	 * C:\Users\jordi\OneDrive\Documentos\GitHub\It-Academy-JordiF\S01T05FloresDelPozoJordi\src\n1exercici1>javac Main.java
	 * C:\Users\jordi\OneDrive\Documentos\GitHub\It-Academy-JordiF\S01T05FloresDelPozoJordi\src\n1exercici1>cd ..
	 * C:\Users\jordi\OneDrive\Documentos\GitHub\It-Academy-JordiF\S01T05FloresDelPozoJordi\src>java n1exercici1.Main
	*/
	
	static String ruta = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici1";
	static ArrayList<File> arxiusOrdenats;
	
	public static void main(String[] args) {
		llistarDirectoriOrdenat(ruta);
		ordernarLlistat();
		mostrarLlistat();
	}

	public static void llistarDirectoriOrdenat(String ruta) {
		File directori = new File(ruta);
		File[] arxius = directori.listFiles();
		
		arxiusOrdenats = new ArrayList<File>();
		
		if (arxius != null) {
			for	(int i = 0; i < arxius.length; i++) {
				arxiusOrdenats.add(arxius[i]);
			}
		}	
	}
	
	public static void ordernarLlistat() {
		Collections.sort(arxiusOrdenats);
	}
	
	public static void mostrarLlistat() {
		String separador = "- ";
		
		for (File arxiu:arxiusOrdenats) {
			System.out.println(separador + arxiu.getName());
		}
	}
}
