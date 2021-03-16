package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {
	
	    public static boolean isValid(final String patternString, String toMatch) {
	    	 Pattern pattern = Pattern.compile(patternString);
	    	 
	        Matcher matcher = pattern.matcher(toMatch);
	        return matcher.matches();
	    }

	
}
