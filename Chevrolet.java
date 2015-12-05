import java.util.ArrayList;
/*
 * @author Shweta
 * Represents Chevrolet manufacturer
 */
public class Chevrolet extends Manufacturer {

private ArrayList<Car> cars;
	
	public Chevrolet() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		System.out.println("Manufacturer Name : Chevrolet");
		System.out.println("Car available in showroom for Chevrolet are :");
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}		
	}

}
