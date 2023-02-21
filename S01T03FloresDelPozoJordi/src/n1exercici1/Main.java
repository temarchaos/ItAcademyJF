package n1exercici1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class Main {
	static ArrayList<Month> monthList = new ArrayList<Month>();
	
	public static void main(String[] args) {
		afegirMesos();
		mostrarMesos();
		afegirMesAgost();
		mostrarMesos();
		
	    Collections.sort(monthList,  new Comparator<Month>() {
	         public int compare(Month m1, Month m2) {
	             try {
	                 SimpleDateFormat sdf = new SimpleDateFormat("MMMM", new Locale("ca", "ES"));
	                 return sdf.parse(m1.name).compareTo(sdf.parse(m2.name));
	             } catch (ParseException ex) {
	                 return m1.name.compareTo(m2.name);
	             }
	         }
	     });
	    
		mostrarMesos();
		
		// Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats
		HashSet<Month> hashSet = new HashSet<>(monthList);
		afegirMesAgost(); // hashSet no permet el dubicat del mes d'Agost
		
		// Pero recorre el hashSet necesitem un for-each
		for (Month month : hashSet) {
            System.out.println(month.name);
        }
		
		// Per recorre la llista amb iterator
		Iterator<Month> it = monthList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().name);
		}
	}
	
	public static void mostrarMesos() {
		// Per recorre una llista amb for
		for (int i = 0; i < monthList.size(); i++) {
			System.out.println(monthList.get(i).name);
		}
		System.out.println("\s");
	}
	
	public static void afegirMesos() {	
		monthList.add(new Month("Gener"));
		monthList.add(new Month("Febrer"));
		monthList.add(new Month("Març"));
		monthList.add(new Month("Abril"));
		monthList.add(new Month("Maig"));
		monthList.add(new Month("Juny"));
		monthList.add(new Month("Juliol"));
		monthList.add(new Month("Setembre"));
		monthList.add(new Month("Octubre"));
		monthList.add(new Month("Novembre"));
		monthList.add(new Month("Desembre"));
	}
	
	public static void afegirMesAgost() {
		monthList.add(new Month("Agost"));
	}
}