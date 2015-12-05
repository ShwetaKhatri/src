import java.util.Comparator;
/*
 * @author Shweta
 * This class represents various methods that can be used for comparing
 * car objects.
 */
public class CarComparator {

	// Compare car by prices
	public static class CompareByPrice implements Comparator<Car>{

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getCarPrice() == o2.getCarPrice()){
				return 0;
			}
			else{
				return o1.getCarPrice() > o2.getCarPrice() ? 1 : -1;			
			}
		}
	}
	
	// Compare car by mileage
	public static class CompareByMileage implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getCarMPG() == o2.getCarMPG()){
			    return 0;
			}
			else {
				return o1.getCarMPG() > o2.getCarMPG() ? 1 : -1;
			}
		}	
	}
	
	// Compare car by Name
	public static class CompareByName implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getCarModelName().equalsIgnoreCase(o2.getCarModelName())) {
				return 0;
			}
			else {
				return o1.getCarModelName().compareTo(o2.getCarModelName());
			}
		}
		
	}
	
	
}
