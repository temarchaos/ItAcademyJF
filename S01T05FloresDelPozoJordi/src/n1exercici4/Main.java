package n1exercici4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static String ruta = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici2";
	static ArrayList<File> arxiusOrdenats;
	static String rutaFitxerGuardar = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici2\\llistatOrdenat.txt";
	static String rutaFitxerLlegir = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici2\\llistatOrdenat.txt";
	
	public static void main(String[] args) {	
		//llistarDirectoriOrdenat(ruta);
		//ordernarLlistat();
		//mostrarLlistat();
		//guadarFitxer();
		llegerFitxer();
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
	
	public static void escriureLlistat(FileWriter fw) {
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
			
			try {
				fw.write(res + separador + arxiu.getName() + ", " + extensio + ", " + sdf.format(arxiu.lastModified()));
				fw.write(System.lineSeparator());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void guadarFitxer() {
		File arxiu = null;
		try {
			arxiu = new File(rutaFitxerGuardar);
			if (arxiu.createNewFile()) {
				System.out.println("Arxiu creat: " + arxiu.getName());
				escriureFitxer(arxiu);
			}else {
				System.out.println("El arxiu ja existeix");
				escriureFitxer(arxiu);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void escriureFitxer(File arxiu) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(arxiu.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			escriureLlistat(fw);
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void llegerFitxer() {
		File arxiu = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			arxiu = new File (rutaFitxerLlegir);
			fr = new FileReader (arxiu);
			br = new BufferedReader(fr);
			
			String linia;
			while((linia = br.readLine())!= null) {
				System.out.println(linia);				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try{                    
				if( null != fr ){   
					fr.close();     
	            }                  
			}catch (Exception e2){ 
				System.out.println(e2.getMessage());
			}
		}
	}
}
