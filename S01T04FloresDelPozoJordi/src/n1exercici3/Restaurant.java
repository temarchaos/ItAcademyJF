package n1exercici3;

public class Restaurant {
	String[] menu = {"Ensalada César", "Solomillo de ternera", "Tarta de queso"};
	
	public void mostrarMenu(String[] plats) {
		try {
			System.out.println("Menu: " + plats[plats.length]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
