package core.utils;

import static org.testng.Assert.*;
import org.testng.Assert;

public class AssertUtils {
	
	public static void isTrue(String message, boolean condition, String testAction){
		try {
			assertTrue(condition);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isFalse(String message, boolean condition, String testAction){
		try {
			assertFalse(condition);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isNull(String message, Object object, String testAction){
		try {
			assertNull(object);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isNotNull(String message, Object object, String testAction){
		try {
			assertNotNull(object);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());	
		}
	}
	
	public static void isEqual(String message, int expected, int actual, String testAction){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isNotEqual(String message, int expected, int actual, String testAction){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isEqual(String message, Object expected, Object actual, String testAction){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	public static void isNotEqual(String message, Object expected, Object actual, String testAction){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace());
		}
	}
	
	private static void failTest(String testAction, String m, StackTraceElement[] stackTrace){
		MessageCollector.addMessage(m);
		for (StackTraceElement ste : stackTrace)
			MessageCollector.addMessage("       " + ste.toString());
		MessageCollector.addMessage("===========================");
		if (testAction == "stop")
			Assert.fail(MessageCollector.getMessage());
	}
}
