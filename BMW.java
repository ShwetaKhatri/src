import java.util.ArrayList;

/*
 * @author Shweta
 */
public class BMW extends Manufacturer {
	private ArrayList<Car> cars;
	
	public BMW() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}
		
	}

	
	
}
