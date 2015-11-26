import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * @author Shweta
 * Administrator class is responsible for adding cars
 * to the show room
 */
public class Administrator {
	
	private static File file;
	private static Scanner reader;
	private static final String carsData = ".//Car.txt";	
	
	/*
	 * @param line, line read from file
	 * @param manufacturers, array representing manufacturers
	 * add cars to manufacturers. 
	 * Format of File is 
	 * Manufacturer Name # Model Name # Price # Mileage 
	 */
	private void addCars(String line,Manufacturer[] manufacturers){
		String[] data = line.split("#");
		for(int i = 0; i < manufacturers.length ;i++) {		
			if(data[0].equalsIgnoreCase(manufacturers[i].getManufacturerName())) {
				Car car = new Car(data[1],Double.parseDouble(data[2]),Integer.parseInt(data[3]));
				manufacturers[i].addCar(car);
			}
			else{
			}
		}
	}
	/*
	 * @param manufacturers, represents an array of manufacturer available in 
	 * show room
	 */
	public void addCarsToManufacturersFromFile(Manufacturer[] manufacturers) {
		try{
			file = new File(carsData);
			reader = new Scanner(new FileReader(file));
			String line;
			while(reader.hasNext()) {
				line = reader.nextLine();
				addCars(line,manufacturers);
			}		
		}
		catch(FileNotFoundException ex) {
			System.out.println(ex);
		}
	}
}
