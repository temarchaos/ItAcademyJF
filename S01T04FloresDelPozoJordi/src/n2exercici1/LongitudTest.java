package n2exercici1;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;


class LongitudTest {

	public static Matcher<String> length(Matcher<? super Integer> matcher) {
	    return new FeatureMatcher<String, Integer>(matcher,
	            "String", "length") {
	    	
	        @Override
	        protected Integer featureValueOf(String actual) {
	            return actual.length();
	        }
	    };
	}
	
	@Test
	void test() {
		 assertThat("Mordor", length(is(8)));
	}
}
