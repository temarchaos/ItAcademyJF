package n1exercici2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculoDniTest {

	CalculoDni calculodni = new CalculoDni();
	
	@ParameterizedTest
	@ValueSource(strings = {"48525911I", "07784300L", "13036175M", "99089477A", "20557982F", "57920248S",
			"04991432H", "45345633Y", "75554868Y", "35394251B"})
	void testCalcularLletra(String document) {
		boolean lletraCalculada = CalculoDni.calcularLletra(document.charAt(8));
		assertEquals(true, lletraCalculada);
		// "48525911I" el primer valor dóna failure perquè no té una lletra vàlida
	}

}
