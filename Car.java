/*
 * Car represents a customized data structure that
 * stores information about cars.
 */
public class Car {

	private static double price;
	private int mileage;
	private String modelName;
	
	/*
	 * @param carName, name of car
	 * @param carPrice, price of the car
	 * @param carMileage , mileage offered by the car
	 * @param carModelName , Model Number of the Car
	 */
	public Car( String carModelName, Double carPrice,int carMileage) {
		price = carPrice;
		mileage = carMileage;
		modelName = carModelName;
	}
	
	/*
	 * @return price of this car object
	 */

	public static double getPrice() {
		return price;
	}

	/*
	 * @return mileage of this car object
	 */
	public int getMileage() {
		return mileage;
	}

	/*
	 * @return model Name of this car object
	 */
	public String getModelName() {
		return modelName;
	}
	
}
