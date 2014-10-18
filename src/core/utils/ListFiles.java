package core.utils;
import java.io.File;

public class ListFiles {
	static String startDirectoryPath = "E:\\TestingFramework\\jTest\\src\\tests\\";
	public static void main(String argv[]) {
		
		File startDirectory = new File(startDirectoryPath);
		list(startDirectory);
	}
	
	public static StringBuilder path = new StringBuilder();
	
	public static void list(File file) {
	    File[] children = file.listFiles();
	    for (File child : children) {
	    	if (child.isDirectory())
	    		list(child);
	    	else
	    		System.out.println(child.getPath().replace(startDirectoryPath, "").replace("\\", "."));
	    }
	}
}
