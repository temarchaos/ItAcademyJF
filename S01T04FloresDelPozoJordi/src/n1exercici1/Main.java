package n1exercici1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class Main {

	static ArrayList<String> monthList;
	
	public static void main(String[] args) {
		afegirMesos();
		mostrarMesos();
		ordenarMesos();
		mostrarMesos();
	}

	public static void afegirMesos() {
		monthList = new ArrayList<String>();
		monthList.add("Gener");
		monthList.add("Febrer");
		monthList.add("Març");
		monthList.add("Abril");
		monthList.add("Maig");
		monthList.add("Juny");
		monthList.add("Juliol");
		monthList.add("Setembre");
		monthList.add("Octubre");
		monthList.add("Novembre");
		monthList.add("Desembre");
		monthList.add("Agost");
	}
	
	public static void mostrarMesos() {
		for (String mes:monthList) {
			System.out.println(mes);
		}
	}
	
	public static void ordenarMesos() {
		Collections.sort(monthList,  new Comparator<String>() {
	         public int compare(String m1, String m2) {
	             try {
	                 SimpleDateFormat sdf = new SimpleDateFormat("MMMM", new Locale("ca", "ES"));
	                 return sdf.parse(m1).compareTo(sdf.parse(m2));
	             } catch (ParseException ex) {
	                 return m1.compareTo(m2);
	             }
	         }
	     });
	}
}
