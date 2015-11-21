/*
 * @author Shweta
 * Reads values from GeneralProperites and Initializes
 * Global variables
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class GlobalVariables {

	public static String[] manufacturer;

	public GlobalVariables() {
		readPropertiesFile();
	}

	/* Read Properties from properties file and initializes
	 * and calls helper method addManufacturers for initializing
	 * manufacturer array
	 */
	private void readPropertiesFile() {
		try {
			File file = new File("GeneralProperties.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				if(key.equals("MANUFACTURERS")) {
					addManufacturers(value);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Adds manufacturer names to Global manufacturer array
	 * @param value,comma separated string value read from 
	 * properties file
	 */
	private static void addManufacturers(String value) {
		String[] manufact = value.split(",");
		int i = 0;
		for(String name : manufact) {
			manufacturer[i++] = name;
		}
	}
}
