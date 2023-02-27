package n1exercici2;

public class CalculoDni {
	
	public static boolean calcularLletra(char lletra) {
		char[] lletresValides = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		for (int i = 0; i < lletresValides.length; i++) {
			if (lletra == lletresValides[i]) {
				return true;
			}
		}
		
		return false;
	}
}
