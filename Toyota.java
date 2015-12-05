import java.util.ArrayList;

public class Toyota extends Manufacturer {

private ArrayList<Car> cars;
	
	public Toyota() {
		cars = new ArrayList<>();
		cars.addAll(this.getCars());
	}

	@Override
	public void printCars() {
		System.out.println("Manufacturer Name : Toyota");
		System.out.println("Car available in showroom for Toyota are :");
		for(int i =0 ; i< cars.size() ;i++) {
			System.out.println(cars.get(i).toString());
		}		
	}

}
