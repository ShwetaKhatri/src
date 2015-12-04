/*
 * Car represents a customized data structure that
 * stores information about cars.
 */
public class Car {

	private double price;
	private int mpg;
	private String modelName;
	
	/*
	 * @param carName, name of car
	 * @param carPrice, price of the car
	 * @param carMileage , mileage offered by the car
	 * @param carModelName , Model Number of the Car
	 */
	public Car( String carModelName, Double carPrice,int carMpg) {
		price = carPrice;
		mpg = carMpg;
		modelName = carModelName;
	}
	
	/*
	 * @return price of this car object
	 */

	public double getPrice() {
		return price;
	}

	/*
	 * @return mileage of this car object
	 */
	public int getMPG() {
		return mpg;
	}

	/*
	 * @return model Name of this car object
	 */
	public String getModelName() {
		return modelName;
	}
	
	@Override
	public String toString() {
		return "Modelname :" + modelName + ", Price:" + price +
				", MPG:" + mpg;
	}
	
}
