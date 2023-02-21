package n2exercici2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	static HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
	
	public static void main(String[] args) {
		restaurantSet.add(new Restaurant("McDonalds", 1));
		restaurantSet.add(new Restaurant("BurguerKing", 2));
		restaurantSet.add(new Restaurant("KFC", 3));
		
		afegirRestaurant("McDonalds", 1);
		afegirRestaurant("McDonalds", 2);
		//mostrarRestaurants();
		
		List<Restaurant> restaurantList = new ArrayList<Restaurant>(restaurantSet);
		restaurantList.sort(Comparator.comparing(Restaurant::getNom).thenComparingInt(Restaurant::getPuntuacio).reversed());
		
		for	(Restaurant res:restaurantList) {
			System.out.println(res.nom + ", " + res.puntuacio);
		}
	}
	
	public static void mostrarRestaurants() {
		for	(Restaurant res:restaurantSet) {
			System.out.println(res.nom + ", " + res.puntuacio);
		}
	}
	
	public static boolean isRestaurantInSet(String nom, int puntuacio) {
		boolean result = false;
		
		for	(Restaurant res:restaurantSet) {
			if (res.nom == nom) {
				if (res.puntuacio == puntuacio) {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static void afegirRestaurant(String nom, int puntuacio) {
		if (!isRestaurantInSet(nom, puntuacio)) {
			restaurantSet.add(new Restaurant(nom, puntuacio));
		}
	}
}