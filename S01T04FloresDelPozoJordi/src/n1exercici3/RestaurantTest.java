package n1exercici3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantTest {
	Restaurant restaurant = new Restaurant();
	String[] menu = {"Ensalada César", "Solomillo de ternera", "Tarta de queso"};
	
	@Test
	void testMostrarMenu() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> restaurant.mostrarMenu(menu));
		assertEquals("Error: ", exception.getMessage());
	}
}
