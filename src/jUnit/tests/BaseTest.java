package jUnit.tests;

import org.testng.Assert;

import core.utils.MessageCollector;

public class BaseTest {
	protected static void tearDown(){
		if (MessageCollector.getNumberOfStepsFailed() > 0){
			Assert.fail(MessageCollector.getMessage());
		}
	}
}
