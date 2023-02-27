package n2exercici1;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class LongitudMatcher extends TypeSafeMatcher<String>{

	String expectedWord;
	
	public LongitudMatcher(String expectedWord) {
		this.expectedWord = expectedWord;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("La paraula esperada hauria de ser així");
		description.appendValue(this.expectedWord);
	}

	@Override
	protected boolean matchesSafely(String arg0) {
		
		return false;
	}

}
