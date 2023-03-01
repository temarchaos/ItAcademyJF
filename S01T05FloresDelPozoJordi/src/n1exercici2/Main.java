package n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static String ruta = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici2";
	static ArrayList<File> arxiusOrdenats;
	
	public static void main(String[] args) {	
		llistarDirectoriOrdenat(ruta);
		ordernarLlistat();
		mostrarLlistat();
	}
	
	public static void llistarDirectoriOrdenat(String ruta) {
		File directori = new File(ruta);
		File[] arxius = directori.listFiles();
		
		if (arxiusOrdenats == null) {
			arxiusOrdenats = new ArrayList<File>();			
		}
		
		if (arxius != null) {
			for	(int i = 0; i < arxius.length; i++) {
				arxiusOrdenats.add(arxius[i]);
				
				if (arxius[i].listFiles() != null) {
					llistarDirectoriOrdenat(ruta+"/"+arxius[i].getName());
				}
			}
		}
	}
	
	public static void ordernarLlistat() {
		Collections.sort(arxiusOrdenats);
	}
	
	public static void mostrarLlistat() {
		String extensio = "";
		String separador = "- ";
		String tab = "\t";
		String res = "";
		
		for (File arxiu:arxiusOrdenats) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			extensio = (arxiu.isDirectory())?"(D)":"(F)";
			
			if (!arxiu.getParent().equals(ruta)) {
				String subPath = arxiu.getParent().substring(ruta.length());
				String[] nivells = subPath.split("\\\\");
				
				for (int i = 0; i < nivells.length-1; i++) {
					res = tab.repeat(i+1);
				}
			}
			
			System.out.println(res + separador + arxiu.getName() + ", " + extensio + ", " + sdf.format(arxiu.lastModified()));
		}
	}
}
