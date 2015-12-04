import java.util.ArrayList;

/*
 * Represents some general accessories offered by car
 * manufacturers.Each manufacturer can set price of 
 * these accessories.
 */
public class Accessory {
	
    private ACCESSORY_TYPE name;
    private String type;
    private double price;
    private  ArrayList<Accessory> currentSelectedArrayList;
    
    public Accessory(ACCESSORY_TYPE name ,String type, double price) {
    	this.name = name;
    	this.type = type;
    	this.price = price;
    	currentSelectedArrayList = new ArrayList<>();
    }

	public String getType() {
		return type;
	}

	public ACCESSORY_TYPE getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
  
	public void addTypes(String type, double price) {
		
	}
	public void setCurrentSelectedAccessories(ArrayList<Accessory> currentSelectedArrayList) {
		this.currentSelectedArrayList = currentSelectedArrayList;
	}
	
	public ArrayList<Accessory>  getCurrentSelectedArrayList() {
		return currentSelectedArrayList;
	}
	
	public String[] getCurrentSelectedList() {
		String[] items = new String[currentSelectedArrayList.size()];
		for(int i = 0; i<currentSelectedArrayList.size();i++) {
			items[i] = currentSelectedArrayList.get(i).toString();
		}
		return items;
	}
	
	@Override
	public String toString() {
		return "Type : " + type + " Price : " + price;
	}
  }
