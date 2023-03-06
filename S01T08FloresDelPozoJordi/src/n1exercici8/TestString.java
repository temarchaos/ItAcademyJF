package n1exercici8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestString {

	@Test
	void test() {
		ReverseString rs = (str) -> {
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		};
		
		String str = "Mordor";
		assertEquals("rodroM", rs.reverse(str));
	}

}
