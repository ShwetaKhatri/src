import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shweta
 * This class represents Car Manufacturers
 *
 */
public abstract class Manufacturer {

	private String manufacturerName;
	private ArrayList<Car> cars;
	private HashMap<String,Accessory> accessories;
	
	public Manufacturer() {
		cars = new ArrayList<Car>();
		accessories = new HashMap<String,Accessory>();		
	}
	
	/*
	 * Sets a Manufacturer Name.
	 */
	public void setManufacturerName(String name){
		if(name!= null) {
			manufacturerName = name;
		}
		else {
			throw new NullPointerException("Please provide a manufacturer name");
		}
	}
	
	/*
	 *@return Manufacturer Name of the object this  
	 */
	public String getManufacturerName(){
		if(manufacturerName != null) {
			return manufacturerName;
		}
		else {
			throw new NullPointerException("Manufacturer not present");
		}
	}
	
	/*
	 * @param car to be added to manufacturer. 
	 */
	public void addCar(Car car){
		if(car!=null) {
			cars.add(car);
		}
		else {
			throw new NullPointerException("Cannot pass null values for Car");
		}
	}
	/*
	 * @param car to be removed from manufacturer
	 */
	public void removeCar(Car car){
		if(cars.contains(car)) {
			cars.remove(car);
		}
		else {
			throw new NullPointerException("Car not present");
		}
	}
	/*
	 * @param accessoryName - Name of the accessory to be added 
	 * @param accessoryValue - Accessory object that stores details about 
	 * accessories offered by a manufacturer
	 */
	public void addAccessories(String accessoryName,Accessory accessoryValue){
		accessories.put(accessoryName, accessoryValue);
	}
	
	/*
	 * @param accessory name
	 * @returns accessory object if accessory is offered by the
	 * manufacturer
	 */
	public Accessory getAccessories(String accessoryName) {
		if(accessories.containsKey(accessoryName)) {
			return accessories.get(accessoryName);
		}
		else {
			throw new NullPointerException("No such accessory offered by manufacturer.");
		}
	}
	
	public abstract void printCars();

	public ArrayList<Car> getCars() {
		return cars;
	}
	
	/*
	 * @return array , stores string representation of cars
	 * for manufacturer
	 */
	public String[] getCarsDetails() {
		String[] details = new String[cars.size()];
		int i = 0;
		for(Car car:cars) {
			details[i++] = car.toString();
		}
		return details;
	}
	
	/*
	 * @param startRange , Range from
	 * @param endRange, Range to
	 * @return array containing cars whose price lies between
	 * start and end range, inclusive 
	 */
	public String[] getCarsInPriceRange(double startRange,double endRange) {
		ArrayList<String> carsInRange = new ArrayList<String>(cars.size());
		Car car;
		for(int i = 0; i< cars.size(); i++) {
			car = cars.get(i);
			if(car.getCarPrice() >= startRange && 
					car.getCarPrice() <= endRange) {
				carsInRange.add(car.toString());
			}
		}
		String[] arr = new String[carsInRange.size()];
		return carsInRange.toArray(arr);		
	}
}
