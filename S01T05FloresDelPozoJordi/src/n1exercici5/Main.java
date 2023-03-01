package n1exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	static String rutaObjecteSerGuardar = "C:\\Users\\jordi\\OneDrive\\Documentos\\GitHub\\It-Academy-JordiF\\S01T05FloresDelPozoJordi\\src\\TestExercici5\\personas.ser";
	
	public static void main(String[] args) {
		serialitzarObjecteFitxer();
	}
	
	public static void serialitzarObjecteFitxer() {
		FileOutputStream fos = null;
		ObjectOutputStream sortida = null;
		Persona p;
		
		try {
			fos = new FileOutputStream(rutaObjecteSerGuardar);
			sortida = new ObjectOutputStream(fos);
			p = new Persona("12345678A","Jordi Flores", 28);
			sortida.writeObject(p);
			p = new Persona("12345678A","Sara Flores", 23);
			sortida.writeObject(p);
			p = new Persona("12345678A","Pedro Flores", 56);
			sortida.writeObject(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (sortida != null) {
					sortida.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void desserialitzarObjecteFitxer() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Persona p;
		
		try {
			fis = new FileInputStream(rutaObjecteSerGuardar);
			entrada = new ObjectInputStream(fis);
			p = (Persona) entrada.readObject();
			System.out.println(p.getDni() + ", " + p.getNom() + ", " + p.getEdad());
			p = (Persona) entrada.readObject();
			System.out.println(p.getDni() + ", " + p.getNom() + ", " + p.getEdad());
			p = (Persona) entrada.readObject();
			System.out.println(p.getDni() + ", " + p.getNom() + ", " + p.getEdad());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (entrada != null) {
					entrada.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
