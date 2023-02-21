package n1exercici3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static HashMap<String, String> capitalPaisos = new HashMap<>();
	static String usarname = "";
	static int puntuacio = 0;
	
	public static void main(String[] args) {
		llegirArxiu();
		//mostrarPaisos();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix l'usuari");
		usarname = scanner.next();
		System.out.println(usarname);	
		
		for	(int i = 0; i < 10; i++) {
			int randomNum = (int)(Math.random() * capitalPaisos.size());
			String randPais = (String) capitalPaisos.keySet().toArray()[randomNum];
			System.out.println(i+1 + ". " + "Quina es la capital de " + randPais + "?");
			String resposta = scanner.next();
			if (resposta.equals(capitalPaisos.get(randPais))) {
				puntuacio++;
				System.out.println("Resposta correcta");
			}else {
				System.out.println("Resposta incorrecta");
			}			
		}
		scanner.close();
		guardarArxiu();
	}
	
	public static void mostrarPaisos() {
		for (String pais : capitalPaisos.keySet()) {
			System.out.println("key: " + pais + " value: " + capitalPaisos.get(pais));
		}
	}
	
	public static void llegirArxiu() {
		File arxiu = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			arxiu = new File("Countries.txt");
			fr = new FileReader (arxiu);
	        br = new BufferedReader(fr);
	        
	        String linia;
	        
	        while((linia = br.readLine()) != null) {
	        	String[] data = linia.split(" ", 2);
	        	capitalPaisos.put(data[0], data[1]);
	        }
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e){ 
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void guardarArxiu() {
		File arxiu = null;
		try {
			arxiu = new File("classificacio.txt");
			if (arxiu.createNewFile()) {
				System.out.println("Arxiu creat: " + arxiu.getName());
				escriureArxiu();
			}else {
				System.out.println("El arxiu ja existeix");
				escriureArxiu();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void escriureArxiu() {
		File arxiu = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			arxiu = new File("classificacio.txt");
			fw = new FileWriter(arxiu.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			fw.write(usarname + " " + puntuacio);
			fw.write(System.lineSeparator());
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
}
