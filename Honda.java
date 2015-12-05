import java.util.ArrayList;
/*
 * @author Shweta
 * Represents Honda manufacturer
 */
public class Honda extends Manufacturer {

private ArrayList<Car> cars;
	
	public Honda() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		System.out.println("Manufacturer Name : Honda");
		System.out.println("Car available in showroom for Honda are :");
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}		
	}

}
