import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileUtil {

	private static File file;
	private static Scanner reader;
	 
	public static void readFile(String fileName) {
		try{
			file = new File(fileName);
			reader = new Scanner(new FileReader(file));
			while(reader.hasNext()) {
				processData(reader.nextLine());
			}
		
		}
		catch(FileNotFoundException ex) {
			System.out.println(ex);
		}
	}
	
	private static void processData(String input) {
		String[] tokens = input.split("#");
		
		}

	
}
