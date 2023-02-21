package n2exercici1;

import java.util.HashSet;

public class Main {

	static HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
	
	public static void main(String[] args) {
		restaurantSet.add(new Restaurant("McDonalds", 1));
		restaurantSet.add(new Restaurant("BurguerKing", 2));
		restaurantSet.add(new Restaurant("KFC", 3));
		
		afegirRestaurant("McDonalds", 1);
		afegirRestaurant("McDonalds", 2);
		mostrarRestaurants();
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