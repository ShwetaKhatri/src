/*
 * Car represents a customized data structure that
 * stores information about cars.
 */
public class Car {

	private double carPrice;
	private int carMpg;
	private String carModelName;
	
	/*
	 * @param carName, name of car
	 * @param carPrice, price of the car
	 * @param carMileage , mileage offered by the car
	 * @param carModelName , Model Number of the Car
	 */
	public Car( String modelName, Double price,int mpg) {
		carPrice = price;
		carMpg = mpg;
		carModelName = modelName;
	}
	
	/*
	 * @return price of this car object
	 */

	public double getCarPrice() {
		return carPrice;
	}

	/*
	 * @return mileage of this car object
	 */
	public int getCarMPG() {
		return carMpg;
	}

	/*
	 * @return model Name of this car object
	 */
	public String getCarModelName() {
		return carModelName;
	}
	
	@Override
	public String toString() {
		return "Modelname :" + carModelName + ", Price:" + carPrice +
				", MPG:" + carMpg;
	}
	
}
