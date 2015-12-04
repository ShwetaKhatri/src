import java.util.Comparator;

public class CarComparator {

	public static class CompareByPrice implements Comparator<Car>{

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getPrice() == o2.getPrice()){
				return 0;
			}
			else{
				return o1.getPrice() > o2.getPrice() ? 1 : -1;			
			}
		}
	}
	
	public static class CompareByMileage implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getMPG() == o2.getMPG()){
			    return 0;
			}
			else {
				return o1.getMPG() > o2.getMPG() ? 1 : -1;
			}
		}	
	}
	
	public static class CompareByName implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			if(o1.getModelName().equalsIgnoreCase(o2.getModelName())) {
				return 0;
			}
			else {
				return o1.getModelName().compareTo(o2.getModelName());
			}
		}
		
	}
	
	
}
