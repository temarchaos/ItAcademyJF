package n1exercici1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testSize() {
		Main.afegirMesos();
		Main.ordenarMesos();
		int mesosCount = Main.monthList.size();
		assertEquals(12, mesosCount);
		//assertEquals(10, mesosCount); Test failure
	}
	
	@Test
	void testNull() {
		Main.afegirMesos();
		Main.ordenarMesos();
		
		assertNotNull(Main.monthList);
	}
	
	@Test
	void testAgost() {
		Main.afegirMesos();
		Main.ordenarMesos();
		
		boolean isValid = false;
		
		if (Main.monthList.get(7) == "Agost") {
			isValid = true;
		}
		assertEquals(true, isValid);
		//assertEquals(false, isValid);
	}
}
