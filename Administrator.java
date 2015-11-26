import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
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

	private String[] manufacturerNames = {"BMW",
			"NISSAN","CHEVORLET",
			"HONDA","TOYOTA"};
	private static Manufacturer[] manufacturers;

	public Administrator() {
		manufacturers = new Manufacturer[manufacturerNames.length];
		addManufacturers();
		addCars();
	}

	private void addManufacturers() {
		System.out.println("Added manufacturer BMW");
		Manufacturer bmw = new BMW();
		bmw.setManufacturerName("BMW");
		manufacturers[0] = bmw;
		
		System.out.println("Added manufacturer Nissan");
		Manufacturer nissan = new Nissan();
		nissan.setManufacturerName("Nissan");
		manufacturers[1] = nissan;
		
		System.out.println("Added manufacturer Chevorlet");
		Manufacturer chevorlet = new Chevrolet();
		chevorlet.setManufacturerName("Chevorlet");
		manufacturers[2] = chevorlet;
		
		System.out.println("Added manufacturer Honda");
		Manufacturer honda = new Honda();
		honda.setManufacturerName("Honda");
		manufacturers[3] = honda;
		
		System.out.println("Added manufacturer Toyota");
		Manufacturer toyota = new Toyota();
		toyota.setManufacturerName("Toyota");
		manufacturers[4] = toyota;
		
	}

	private void addCars(String line){
		String[] data = line.split("#");
		for(int i = 0; i < manufacturers.length ;i++) {		
			if(data[0].equalsIgnoreCase(manufacturers[i].getManufacturerName())) {
				Car car = new Car(data[1],Double.parseDouble(data[2]),Integer.parseInt(data[3]));
				System.out.println("Adding car " + car.toString() + " to manufacturer " + manufacturers[i].getManufacturerName());
				manufacturers[i].addCar(car);
			}
			else{
			}
		}
	}
	
	private void addCars() {
		try{
			file = new File(carsData);
			reader = new Scanner(new FileReader(file));
			String line;
			while(reader.hasNext()) {
				line = reader.nextLine();
				addCars(line);
			}		
		}
		catch(FileNotFoundException ex) {
			System.out.println(ex);
		}
	}
}
