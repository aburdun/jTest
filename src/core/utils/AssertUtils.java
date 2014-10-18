package core.utils;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertUtils {
	
	public static void isTrue(String message, boolean condition, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertTrue(condition);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
//			collector.takeScreenShot(driver, message);
		}
	}
	
	public static void isFalse(String message, boolean condition, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertFalse(condition);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
		}
	}
	
	public static void isNull(String message, Object object, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertNull(object);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
		}
	}
	
	public static void isNotNull(String message, Object object, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertNotNull(object);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);	
		}
	}
	
	public static void isEqual(String message, int expected, int actual, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
			collector.takeScreenShot(driver, message);
		}
	}
	
	public static void isNotEqual(String message, int expected, int actual, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
		}
	}
	
	public static void isEqual(String message, Object expected, Object actual, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
		}
	}
	
	public static void isNotEqual(String message, Object expected, Object actual, String testAction, WebDriver driver, MessageCollector collector){
		try {
			assertNotEquals(expected, actual);
		}
		catch (AssertionError e){
			failTest(testAction, message, e.getStackTrace(), driver, collector);
		}
	}
	
	private static void failTest(String testAction, String m, StackTraceElement[] stackTrace, WebDriver driver, MessageCollector collector){
		collector.addMessage(m);
		for (StackTraceElement ste : stackTrace)
			collector.addMessage("       " + ste.toString());
		collector.addMessage("===========================");
		if (testAction == "stop")
			Assert.fail(collector.getMessage());
	}
}
