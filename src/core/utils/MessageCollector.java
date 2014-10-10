package core.utils;

public class MessageCollector {
	private static StringBuilder message = new StringBuilder("\n===========================\n");
	private static int stepsFailed = 0;
	public static void addMessage(String str){
		message.append(str + "\n");
		stepsFailed++;
	}
	
	public static String getMessage(){
		return message.toString();
	}
	
	public static int getNumberOfStepsFailed(){
		return stepsFailed;
	}
	
}
