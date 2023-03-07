package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println(llegirByte("Error de format: "));
		//System.out.println(llegirInt("Error de format: "));
		//System.out.println(llegirFloat("Error de format: "));
		//System.out.println(llegirDouble("Error de format: "));
		//System.out.println(llegirChar("Error de format: "));
		//System.out.println(llegirSiNo("Error de format: "));
	}
	
	// Mètodes a implantar capturant l’excepció de la classe InputMismatchException
	public static byte llegirByte(String missatge) {
		boolean inputValid = false;
		Byte edat = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Edat: ");
				edat = scanner.nextByte();
				inputValid = true;
			} catch (InputMismatchException e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}
		}
		
		return edat;
	}
	
	public static int llegirInt(String missatge) {
		boolean inputValid = false;
		int any = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Any: ");
				any = scanner.nextInt();
				inputValid = true;
			} catch (InputMismatchException e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}
		}
		
		return any;		
	}
	
	public static float llegirFloat(String missatge) {
		boolean inputValid = false;
		float sou = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Sou: ");
				sou = scanner.nextFloat();
				inputValid = true;
			} catch (InputMismatchException e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}
		}
		
		return sou;
	}
	
	public static double llegirDouble(String missatge) {
		boolean inputValid = false;
		double altura = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Altura: ");
				altura = scanner.nextDouble();
				inputValid = true;
			} catch (InputMismatchException e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}
		}
		
		return altura;
	}
	
	// Mètodes a implantar capturant l’excepció de la classe Exception
	public static char llegirChar(String missatge) {
		boolean inputValid = false;
		char c = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Lletra inicial nom: ");
				c = scanner.next().charAt(0);
				inputValid = true;
			} catch (Exception e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}
		}
		
		return c;
	}
	
	public static String llegirString(String missatge) {
		boolean inputValid = false;
		String nom = "";
		
		while (!inputValid) {
			try {
				System.out.println("Nom: ");
				nom = scanner.next();
				inputValid = true;
			} catch (Exception e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}		
		}
		
		return nom;
	}
	
	public static boolean llegirSiNo(String missatge) {
		boolean inputValid = false;
		char c = 0;
		
		while (!inputValid) {
			try {
				System.out.println("Escrigui s o n ");
				c = scanner.next().charAt(0);

				if (c == 's' || c == 'n') {
					inputValid = true;
				}
			} catch (Exception e) {
				System.out.println(missatge + e.getMessage());
				scanner.next();
			}		
		}
		
		if (c == 's') {
			return true;
		}else {
			return false;
		}
	}
}
