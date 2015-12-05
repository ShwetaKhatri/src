import java.util.ArrayList;
/*
 * @author Shweta
 * Represents Nissan manufacturer
 */
public class Nissan extends Manufacturer{

private ArrayList<Car> cars;
	
	public Nissan() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		System.out.println("Manufacturer Name : Nissan");
		System.out.println("Car available in showroom for Nissan are :");
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}		
	}

}
