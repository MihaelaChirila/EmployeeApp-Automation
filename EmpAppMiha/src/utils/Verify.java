package utils;



public class Verify {

	public static void equals(String expected, String actual) {
		if(!expected.equals(actual)) {
			Logger.verification.add(expected + " is not equal with: " + actual);
			
		}
	}
}
