import java.util.ArrayList;

/*
 * @author Shweta
 * Represents price and type of accessory
 */
public class Accessory {
	
    private ACCESSORY_NAME accessoryName;
    private String accessoryType;
    private double accessoryPrice;
    private ArrayList<String> accessories;
    
    /*
     * @param name, name of accessory of type ACCESSORY_NAME
     */
    public Accessory(ACCESSORY_NAME name) {
    	this.accessoryName = name;
    	accessories = new ArrayList<>();
    }

    /*
     * @return type of accessory
     */
	public String getAccessoryType() {
		return accessoryType;
	}

	/*
	 * @return name of accessory
	 */
	public ACCESSORY_NAME getAccessoryName() {
		return accessoryName;
	}

	/*
	 * @return price of accessory
	 */
	public double getAccessoryPrice() {
		return accessoryPrice;
	}
  
	/*
	 * @param type of accessory whose name is provided
	 * by constructor
	 * @param price of accessory whose name is provided 
	 * by constructor
	 * Adds type and price to array list that stores accessories
	 * provided by ACCESSORY_NAME
	 */
	public void addAccessories(String type, double price) {
	  	this.accessoryType = type;
    	this.accessoryPrice = price;
		String value = "Type :" + type + " Price :" + price;
		accessories.add(value);
	}
	
	/*
	 * @return string array that stores types and prices
	 * of accessoryName
	 */
	public String[] getAccessoriesDetails() {
		String[] items = new String[accessories.size()];
		for(int i = 0; i<accessories.size();i++) {
			items[i] = accessories.get(i);
		}
		return items;
	}
	
	/*
	 * @param startRange , Range from
	 * @param endRange, Range to
	 * @return array containing cars whose price lies between
	 * start and end range, inclusive 
	 */
	public String[] getAccessoryInPriceRange(Double startRange, Double endRange) {
		ArrayList<String> accessoriesInRange = new ArrayList<>();
		String currentItem;
		for(int i = 0; i< accessories.size();i++) {
			currentItem = accessories.get(i);
			double p = getPriceFromString(currentItem);
			if(p >= startRange && p <= endRange) {
				accessoriesInRange.add(currentItem);
			}
			else{
				continue;
			}			
		}
		String[] output = new String[accessoriesInRange.size()];
		for(int i =0 ;i <accessoriesInRange.size();i++) {
			output[i] = accessoriesInRange.get(i);
		}
		return output;
		
	}
	/*
	 * @param stringRepresentationOfAccessory, toString() representation of accessory
	 * @return price extracted from input
	 */
	public double getPriceFromString(String stringRepresentationOfAccessory) {
		int startIndex = stringRepresentationOfAccessory.lastIndexOf(":");
		int endIndex = stringRepresentationOfAccessory.length();
		String price = stringRepresentationOfAccessory.substring(startIndex+1, endIndex);
		Double p = Double.parseDouble(price);
		return p;
	}
	
	@Override
	public String toString() {
		return "Type : " + accessoryType + " Price : " + accessoryPrice;
	}
  }
