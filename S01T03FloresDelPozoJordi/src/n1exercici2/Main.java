package n1exercici2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {
	
	public static void main(String[] args) {
		// Crea i emplena un List<Integer>
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		
		// Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list);
		Collections.reverse(list2);
		//list2.forEach(System.out::println);
		list2.clear();
		
		// Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona
		ListIterator<Integer> listIterator
        = list.listIterator();
		
		while (listIterator.hasNext()) {
			list2.add(listIterator.next());
        }
		
		list2.forEach(System.out::println);
	}
}
