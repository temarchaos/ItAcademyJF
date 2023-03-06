package n1exercici1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> llistat = new ArrayList<String>();
		ArrayList<String> cadenes = new ArrayList<String>();
		
		llistat.add("hola");
		llistat.add("como");
		llistat.add("estas");
		llistat.add("amigo");
		llistat.add("programador");
		
		cadenes = retornaCadenes(llistat, "o");
		cadenes.forEach(c -> System.out.println(c));
	}
	
	public static ArrayList<String> retornaCadenes(ArrayList<String> llistat, CharSequence caracter) {
		return llistat.stream()
				.filter(str -> str.contains(caracter))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
