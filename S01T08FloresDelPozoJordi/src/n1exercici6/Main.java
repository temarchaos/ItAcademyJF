package n1exercici6;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> llistat = new ArrayList<String>();
		
		llistat.add("Jordi");
		llistat.add("Pedro");
		llistat.add("Sara");
		llistat.add("Maria Dolores");
		llistat.add("Montse");
		llistat.add("Ramon");
		
		Comparator<String> lenghtComparator = (s1, s2) -> s1.length() - s2.length();
		llistat.stream()
			.sorted(lenghtComparator)
			.forEach(System.out::println);
	}

}
