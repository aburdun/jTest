package core.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MessageCollector {
	private StringBuilder message = new StringBuilder("\n===========================\n");
	private int stepsFailed = 0;
	private int counter = 1;
	private String testName;
	
	public void addMessage(String str){
		message.append(str + "\n");
		stepsFailed++;
	}
	
	public String getMessage(){
		return message.toString();
	}
	
	public int getNumberOfStepsFailed(){
		return stepsFailed;
	}
	
	public void clearMessages(){
		message.setLength(0);
	}
	
	public void takeScreenShot(WebDriver driver, String m){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\TestResults\\" + testName + "__" + m.replaceAll("[^a-zA-Z0-9-_\\.]", "_") + counter + ".png"));
			counter++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void collectMessages(MessageCollector collector){
    	if (collector.getNumberOfStepsFailed() > 0){
			Assert.fail(collector.getMessage());
		}
    }
}
