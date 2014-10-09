package core.utils;

import static org.testng.Assert.*;
import org.testng.Assert;

public class AssertUtils {
	
	public static void isTrue(String message, boolean condition){
		try {
			assertTrue(condition);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isFalse(String message, boolean condition){
		try {
			assertFalse(condition);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isNull(String message, Object object){
		try {
			assertNull(object);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isNotNull(String message, Object object){
		try {
			assertNotNull(object);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isEqual(String message, int expected, int actual){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isNotEqual(String message, int expected, int actual){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isEqual(String message, Object expected, Object actual){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
	
	public static void isNotEqual(String message, Object expected, Object actual){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			Assert.fail(message + e.getMessage());
		}
	}
}
