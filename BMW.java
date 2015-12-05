import java.util.ArrayList;

/*
 * @author Shweta
 * Represents BMW manufacturer
 */
public class BMW extends Manufacturer {
	private ArrayList<Car> cars;
	
	public BMW() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		System.out.println("Manufacturer Name : BMW");
		System.out.println("Car available in showroom fro BMW are :");
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}		
	}

	
	
}
